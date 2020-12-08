(ns clojure-noob.core
  (:gen-class))

(defn cl-print [x] (doto x (print)))

(defn hello [name]
  (println "Hello" name))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Welcome! Time to play! Try to use all of your letters.")
  (println "The first player that uses all of their letters wins!")
  (println "How many players will be playing?")
  (let [num_players (read-line)]))
  (for [num_players]
  (println "Enter the name for player #"))

