(ns motific.core
  (:gen-class)
  (:require [motific.util :as util]
            [motific.anagram :as anagram]
            [motific.word-list :as word-list]
            [motific.output :as output])
  (:use [clojure.tools.cli :only [cli]]))

(defn get-anagram
  "fn to fetch anagrams"
  ([settings]
    (let [words (word-list/generate (-> settings :options :from))
          finder (partial anagram/find-in-list words)]
      (into {} (pmap #(vector % (finder %)) (:params settings))))))

(defn get-permutate
  "fn that returns a map of all permutations of supplied words."
  ([settings]
    (into {} (pmap #(vector % (-> (anagram/permutate %) (sort) (distinct))) (:params settings)))))

(defn get-random
  "fn for 'random' action"
  ([settings]
    (let [options (:options settings)
          words (word-list/generate (:from options))]
      (into [] (util/pass-args (partial word-list/random words) options)))))

(defn unknown-action
  "Display a helpful message if passed an unknown action."
  ([action]
    (println (str "\nI don't know what to do with '" action "'.\n"))))

(def actions
  "Hash to store action-to-fn mappings. Help returns nil as a default so output/process will just display the banner"
  {:random get-random :anagram get-anagram :permutate get-permutate :help (constantly nil)})

(defn- parse-cli
  "Parse command-line opts with tools.cli"
  [args]
  (let [to-int #(Integer. %)]
    (cli
      args
      ["-q" "--quantity" "Quantity of returned results." :default 10 :parse-fn to-int]
      ["-m" "--min-length" "Minimum length of words." :default nil :parse-fn to-int]
      ["-M" "--max-length" "Maximum length of words." :default nil :parse-fn to-int]
      ["-e" "--exact-length" "Exact length of words." :default nil :parse-fn to-int]
      ["-f" "--from" "The word-list to select from" :default (or (word-list/find-installed) "No default!")]
      ["-F" "--[no-]fixed-length" "Whether permutations should be fixed-length" :flag false :default false]
      ["-o" "--output" "Output format" :default 'text :parse-fn output/select])))

(defn- get-settings
  "Wrapper around parse-cli." ; TODO: merge the two?
  ([args]
    (let [[options [action & params] banner] (parse-cli args)]
      {:options options :action action :params params :banner banner :data nil :output nil})))

(defn- run-actions
  "Given a settings map, runs the action specified and assocs whatever is returned to :data"
  [settings]
  (let [action (:action settings) action-fn (get actions (keyword action))]
    (assoc settings :data
      (cond
        (fn? action-fn) (action-fn settings)
        ; unknown-action will return nil, just displays an error
        (not (nil? action)) (unknown-action action)
        :else nil))))

(defn -main
  ([& args]
    (println (->> (get-settings args) (run-actions) (output/process) (:output)))))
