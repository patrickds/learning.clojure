(defproject learning.clojure "0.1.0-SNAPSHOT"
  :description "Clojure Playground"
  :url "https://github.com/patrickds/learning.clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main helloworld
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [failjure "1.2.0"]]
  :profiles {:dev {:plugins [[com.jakemccrary/lein-test-refresh "0.22.0"]]}})
