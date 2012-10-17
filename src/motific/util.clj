(ns motific.util
  (:import [java.io File])
  (:require [clojure.string :as string]))

(defn clean
  ([w & {:keys [strip-whitespace] :or {strip-whitespace false}}]
    (string/lower-case (if strip-whitespace (string/replace w #"\s" "") w))))

(defn file-exists
  "Pred function for use with some,
    returns the path if exists and isFile"
  ([path]
    (let [f (File. path)]
      (and
        (.exists f)
        (.isFile f)
        path))))

(defn pass-args
  "Allows one to pass a hash to a variadic function that expects keyword args"
  ([f args]
    (apply f (interleave (keys args) (vals args)))))

(defn in?
  "Check to see if a collection contains an item"
  ([coll & items]
    (not (nil? (some (set items) coll)))))

