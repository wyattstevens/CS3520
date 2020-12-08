(ns clojure-noob.core
  (:gen-class))

(defn hello [name]
  (println "Hello" name))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot!")
  (hello (read-line)))

