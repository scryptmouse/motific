(ns motific.test.util
  (:use [motific.util])
  (:use expectations))

(expect "teststring" (clean "test string" :strip-whitespace true))
(expect "test string" (clean "Test String"))

(expect true? (in? ["hello"] "hello"))
(expect false? (in? ["hello"] "goodbye"))

(expect (complement nil?) (file-exists "./project.clj"))
