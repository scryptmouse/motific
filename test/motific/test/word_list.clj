(ns motific.test.word-list
  (:require [motific.test.helpers :as helpers])
  (:use expectations motific.word-list))

(def sample-import ["some" "Test" "words" "my" "Words" "apple" "floccinaucinihilipilification"])
(def sample-valid-words ["apple" "some" "test" "words"])
; This file contains the same words as sample-import
(def sample-words-file "./test/sample.words")

(expect sample-valid-words (filter-valid sample-import))

(let [words (generate sample-words-file)]
  (helpers/lazy? words)
  (expect 4 (count words)))

(let [words (generate)]
  (helpers/lazy? words))


