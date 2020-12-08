(ns clojure-noob.core
  (:gen-class))

;subtracts two lists, i didnt write this so idk how it works
(defn diff [s1 s2]
  (mapcat
    (fn [[x n]] (repeat n x))
    (apply merge-with - (map frequencies [s1 s2]))))


(defn -main
  [& args]
  ;(require '[clojure.string :as str])
  (def alphabet ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"])
  
  (println "Enter the name for player 1!")
  (def player1 (read-line))
  (println "Enter the name for player2!")
  (def player2 (read-line))

  (println "Hello " player1)
  (println "Hello " player2)

  ;This line takes ten letters from the nth index of alphabet.
  (def p1_letters (take 10 (repeatedly #(nth alphabet (rand-int 26)))))
  (println p1_letters)

  (def p2_letters (take 10 (repeatedly #(nth alphabet (rand-int 26)))))
  (println p2_letters)
 
  ;deconstructs player 1s output into a list of characters instead of a string
  (println "Player 1 choose a word")
  (def p1_choice (read-line))
  (def p1_choice_dec (clojure.string/split p1_choice #""))
  (println p1_choice_dec)

  ;subtracts player 1s choice from their character list
  (def new_list (diff p1_letters p1_choice_dec))
  (println new_list)

 
  ;deconstructs player 2s output into a list of characters instead of a string
  (println "Player 2 choose a word")
  (def p2_choice (read-line))
  (def p2_choice_dec (clojure.string/split p2_choice #""))
  (println p2_choice_dec)

  ;subtracts player 2s choice from their character list
  (def new_list (diff p2_letters p2_choice_dec))
  (println new_list)
  )
