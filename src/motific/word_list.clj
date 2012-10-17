(ns motific.word-list
  (:require [clojure.string :as string]
            [motific.util :as util]))

(def ^{:private true} default-params {:min-length nil :max-length nil :exact-length nil :quantity 10})
(def ^{:private true} default-generate-params (merge default-params {:min-length 3 :max-length 10}))
(def ^{:private true} default-wordlists ["/usr/share/dict/words" "/usr/dict/words" "./words"])

(defn- compare-with
  "Generate a comparison function for param,
    returns a function that constantly returns true if param === nil"
  ([f param]
    (if (nil? param)
      (constantly true)
      #(f % param))))

(defn- valid-word?
  ([w]
    ((complement nil?) (re-matches #"^[a-z]+$" w))))

(defn find-installed
  "Searches standard unix paths for installed words file."
  []
  (some util/file-exists default-wordlists))

(defn valid-word-length?
  "Returns a comparator function that checks the length of a word based on specific parameters"
  ([& {:keys [min-length max-length exact-length quantity] :or default-params}]
    (let [at-least? (compare-with >= min-length) at-most? (compare-with <= max-length) exactly? (compare-with = exact-length)]
      #(let [length (count %)]
         (every? true? ((juxt at-least? at-most? exactly?) length))))))

(defn filter-valid
  "Take a sequence of words and lowercases, sorts,
    removes duplicates, and filters the sequence
    based on word length and whether the word is
    only #\"[a-z]\"."
  ([wordlist]
    (let [length-ok? (util/pass-args valid-word-length? default-generate-params)]
      (filter
        #(every? true? ((juxt length-ok? valid-word?) %))
        (distinct
          (sort
            (map string/lower-case wordlist)))))))

(defn generate
  "Generate a word-list collection from 'file'"
  ([]
    (let [default (find-installed)]
      (if (nil? default)
        (do
          (prn "Cannot find words file in any default paths, and one wasn't supplied.")
          (System/exit 1))
        (generate default))))
  ([file]
    (generate file {}))
  ([file params]
    (filter-valid (string/split-lines (slurp file)))))

(defn random
  "Returns a randomized sequence of words from a collection with optional parameters:
    [min-length max-length exact-length quantity]
    Pass 'nil' to the quantity parameter to get the lazy sequence instead of a set quantity."
  ([words & {:keys [min-length max-length exact-length quantity] :or default-params :as args}]
    (let [filtered (filter (util/pass-args valid-word-length? args) (shuffle words))]
      (if (nil? quantity) filtered (take quantity filtered)))))

