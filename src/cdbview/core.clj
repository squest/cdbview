(ns cdbview.core
  (:require [com.ashafa.clutch :as cl]
            [cemerick.url :as curl]
            [clj-http.client :as client]
            [cheshire.core :as cc]
            [selmer.parser :as parse]))

(defn create-view
  "This one accepts a filename complete with the path and a viewmap
  which contains kv pair of variables you want to change inside the
  file, selmer-style"
  [fname viewmap]
  (parse/render-file fname
                     viewmap))

(defn save-view!
  "Save a generic couchdb view into couchdb instance, couchmap must
  contain :host (e.g. http://localhost:5984 or
  http://mizone.cloudant.com of the couchdb target, :dbname all are
  strings, ddname and view-name are document design name and view-name
  for couch, must not be a ddname that already exist in the couchdb
  target. You must supply username password in the host if required."
  [couchmap dd-name view-name map-string]
  (let [{:keys [host dbname]} couchmap
        bodytemp (cc/generate-string
                  {:_id      (str "_design/" dd-name)
                   :language "javascript"
                   :views    {view-name {"map" map-string}}})]
    (client/put (str (curl/url host dbname "_design" dd-name))
                {:body bodytemp 
                 :content-type :json})))






