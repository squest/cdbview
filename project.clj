(defproject zenedu/cdbview "0.1.0"
  :description "FIXME: write description"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [selmer "0.7.7"]
                 [clj-http "1.0.1"]]
  :url "https://github.com/squest/cdbview"
  :plugins [[codox "0.8.10"]
            [lein-autoexpect "1.4.2"]]
  :scm {:name "git"
        :url "https://github.com/squest/cdbview"}
  :signing {:gpg-key "3F84379F"}
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :pom-addition [:developers [:developer
                              [:name "Zenius Education"]
                              [:url "http://github.com/zeniuseducation"]
                              [:timezone "+7"]]]
  :repositories [["releases" {:url "http://clojars.org/repo"
                              :creds :gpg}]])



