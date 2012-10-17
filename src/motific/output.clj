(ns motific.output
  (:require [cheshire.core :as json]
            [clojure.data.xml :as xml]
            [clj-yaml.core :as yaml]
            [clojure.string :as string]))

(def formats #{"text" "yaml" "json" "clj" "xml"})

(defn select
  "motific.core/parse-cli's :parse-fn to select --output format."
  ([fmt]
    (symbol (or (formats fmt) "text"))))

(defmulti writer
  "Translates data to a format that is specified in settings."
  (fn [settings data]
    (-> settings :options :output)))

(defmethod writer
  'clj [settings data]
  data)

(defmethod writer
  'json [settings data]
  (json/generate-string
    (case (:action settings)
      "random" data
      (into {} data))))

(defmethod writer
  'xml [settings data]
  (xml/emit-str
    (xml/element
      :motific {:action (:action settings)}
      (case (:action settings)
        "random" (xml/element :random {} (map #(xml/element :word {} %) data))
        (for [[word words] data]
          (xml/element
            :wordgroup {:original word}
            (map #(xml/element :word {} %) words)))))))

(defmethod writer
  'yaml [settings data]
  (yaml/generate-string
    (case (:action settings)
      "random" data
      (into {} data))))

(defmethod writer
  :default [settings data]
  (string/join \newline
    (case (:action settings)
      "random" data
      (for [[word words] data]
        (str word \: \space (string/join \space words))))))

(defn process
  "Process the :data from the settings map provided by motific.core/-main"
  [settings]
  (let [data (:data settings) options (:options settings)]
    (do
      (shutdown-agents) ; permutate / anagram use pmap
      (assoc settings :output
           (if (nil? data) (:banner settings) (writer settings data))))))
