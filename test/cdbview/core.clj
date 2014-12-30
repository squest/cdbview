(ns cdbview.test.core
  (:require [expectations :refer :all]
            [cdbview.core :refer :all]
            [selmer.parser :refer [render-file]]))

(def couchdd {:host "http://localhost:5984/"
              :dbname "party-animals"
              :username "threemonkeys"
              :password "randomintegerfrom1to1000 :)"})

(expect (render-file "resources/view1.js" {})
        (create-view "resources/view1.js" {}))

(expect Map?
        (save-view! couchdb
                    "testBySoal"
                    "bySoal"
                    (create-view "resources/view1.js"
                                 {})))

(expect Map?
        (save-view! couchdb
                    "testByTest"
                    "byTest"
                    (create-view "resources/view2.js"
                                 {:type "ctype"
                                  :variables "document"
                                  :thekey "somekey"})))




