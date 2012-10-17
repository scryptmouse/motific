(ns motific.test.helpers
  (:use [expectations]))

(defmacro lazy? [x]
  "Test if x is lazy"
  `(expect true? (instance? clojure.lang.LazySeq ~x)))
