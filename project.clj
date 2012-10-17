(defproject motific "0.0.1-SNAPSHOT"
  :description "A collection of functions for manipulating words, anagrams, etc"
  :main motific.core
  :url "http://github.com/scryptmouse/motific"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [org.clojure/tools.cli "0.2.2"]
                 [org.clojure/data.xml "0.0.6"]
                 [org.clojure/data.json "0.2.0"]
                 [clj-yaml "0.4.0"]]
  :dev-dependencies [[expectations "1.4.10"]
                     [lein-expectations "0.0.5"]
                     [lein-autodoc "0.9.0"]])
