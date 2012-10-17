(ns motific.test.anagram
  (:use [motific.anagram])
  (:use expectations))

(def sample-list ["arc" "bar" "baz" "bubble" "car" "care" "foo" "hello" "race" "racecar" "quux" "zoo"])

(expect true? (has-anagrams? "racecar" "car"))
(expect false? (has-anagrams? "racecar" "blurp"))

(let [test-finder (partial find-in-list sample-list)]
  (expect ["arc" "car" "care" "race" "racecar"] (test-finder "racecar"))
  (expect empty? (test-finder "quimby")))

(expect ["a" "ab" "abc" "ac" "acb" "b" "ba" "bac" "bc" "bca" "c" "ca" "cab" "cb" "cba"] (sort (permutate "abc")))
(expect ["a" "ab" "b" "ba"] (sort (permutate "ab")))
(expect ["abc" "acb" "bac" "bca" "cab" "cba"] (sort (permutate "abc" :fixed-length true)))

(expect [\e \l \l \h \o] (insert-letter \h [\e \l \l \o] 3))
