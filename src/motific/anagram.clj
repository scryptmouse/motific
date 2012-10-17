(ns motific.anagram
  (:require [clojure.string :as string]
            [motific.util :as util]))

(def ^{:private true} max-find-qty 1000)

(defn- str-to-vec
  [s]
  (into (vector-of :char) (vec s)))

(defn- similar-frequencies?
  ([original-freq subject-freq]
    (let [[letter occurrences] subject-freq]
      (and
        (contains? original-freq letter)
        (>= (original-freq letter) occurrences)))))

(defn insert-letter
  "Step 3 permutation: inserts a letter into word-vector given position 'pos'."
  ([letter word pos]
    (into (vector-of :char) (concat (conj (subvec word 0 pos) letter) (subvec word pos)))))

(defn add-letter-to-word
  "Step 2 permutation, accepts a word-vector and adds a letter at every position"
  ([letter word]
    (let [available-positions (range (inc (count word)))]
      (map (partial insert-letter letter word) available-positions))))

(defn add-letter-to-each-word
  "Step 1 permutation, accepts a collection of words as vectors and adds a letter to each"
  ([letter words]
    (mapcat (partial add-letter-to-word letter) words)))

(defn permutate
  "Generates all possible permutations of a word.
    Specify :fixed-length true to only return permutations
    that are the same length."
  ([w & {:keys [fixed-length] :or {fixed-length false}}]
    (loop [letters (str-to-vec w) anagrams []]
      (if (empty? letters)
        (let [strung (map string/join anagrams) original-len (count w)]
          (if (true? fixed-length)
            (filter #(= original-len (count %)) strung)
            strung))
        (recur
          (subvec letters 1)
          (concat anagrams (add-letter-to-each-word (first letters) (conj anagrams (vector-of :char)))))))))

(defn has-anagrams?
  "If passed one word, returns an anonymous function for use as
    a comparator, else compares the words and returns a boolean"
  ([first-word]
    (let [first-freq (frequencies first-word)
          has-same-letters? (partial similar-frequencies? first-freq)]
      #(every? has-same-letters? (frequencies %1))))
  ([first-word & other-words]
    (every? (has-anagrams? first-word) other-words)))

(defn get-valid
  "Just a wrapper around permutate to sort / distinct"
  ([w]
    (distinct (sort (permutate w)))))

(defn get-valid-in-list
  "Supply a word to generate anagrams for followed by a list of valid words"
  ([w words]
    (vec (filter (partial util/in? words) (get-valid w)))))

(defn find-in-list
  "Given list 'words', checks to see possible anagrams for word 'w'"
  ([words w]
    (take max-find-qty (filter (has-anagrams? w) words))))
