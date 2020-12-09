(ns clojure-noob.core
  (:gen-class))

;subtracts two lists, i didnt write this so idk how it works
(defn diff [s1 s2]
  (mapcat
    (fn [[x n]] (repeat n x))
    (apply merge-with - (map frequencies [s1 s2]))))

(defn cl-print [x] (doto x (print)))

(def alphabet ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"])
(def gameOver false)

;builds a list of size n specified by user that prompts for name size of list times.
(defn build-names-vector [n]
  (let [stop n]
    (loop [i 0 acc {}]   
      (if (< i stop) 
        (do
          ;(println "Enter the name for player #" (+ i 1))
          ;(def pName (read-line))
          (recur (inc i) (assoc acc i (take 10 (repeatedly #(nth alphabet (rand-int 26)))))))
        (do 
 ;         (println acc) 
          acc)))))
 
;this loop is intended to switch between players and allow each player to take their turn until someone wins.
(defn take-turns [acc]
  (let [stop false] 
    (loop [i 0 new_acc acc] 

      (def letter_count (new_acc i))
      (if (and (not stop) ( not(= 0 (count letter_count))) )
        (do
          (println "")
          (println "Player #" (+ 1 i) ", it is your turn!")
          (println "Your letters are:" (get new_acc i))
          (println "Enter a word to play:")

          (def user_input (read-line))
          (def user_dec_input (clojure.string/split user_input #""))
          (def old_letters (into [] (new_acc i)))
          (def new_letters (diff old_letters user_dec_input))
          

          ;(doseq [[k v] acc]
            ;(println k ", it is your turn!")
            ;

          ; Resets i to 0 after the last player takes their turn
          (def x (count new_acc))
          (if (= i (- x 1))  
          (recur (* i 0) (assoc new_acc i new_letters))
          (recur (inc i) (assoc new_acc i new_letters)))
          
          )
        (do 
          i)))))
          

(defn -main
  [& args]
  ;(require '[clojure.string :as str])
  
  (println "Welcome! Time to play! Try to use all of your letters.")
  (println "The first player that uses all of their letters wins!")
  (println "How many players will be playing?")
  (let [players (build-names-vector (Integer/parseInt (read-line)))]
    (println "Great! Now we can play!")
    (let [winningPlayer (take-turns players)]
      (println "Player" (+ 1 winningPlayer) "wins!!")))
 
  ;deconstructs player 1s output into a list of characters instead of a string
  ;(println "Player 1 choose a word")
  ;(def p1_choice (read-line))
  ;(def p1_choice_dec (clojure.string/split p1_choice #""))
  ;(println p1_choice_dec)

  ;subtracts player 1s choice from their character list
  ;(def new_list (diff p1_letters p1_choice_dec))
  ;(println new_list)

 
  ;deconstructs player 2s output into a list of characters instead of a string
  ;(println "Player 2 choose a word")
  ;(def p2_choice (read-line))
  ;(def p2_choice_dec (clojure.string/split p2_choice #""))
  ;(println p2_choice_dec)

  ;subtracts player 2s choice from their character list
  ;(def new_list (diff p2_letters p2_choice_dec))
  ;(println new_list)
  )

;(defn hello [name]
;  (println "Hello" name))

;(defn -main
 ; [& args]
  ;(println "Welcome! Time to play! Try to use all of your letters.")
  ;(println "The first player that uses all of their letters wins!")
  
  ;(for [num_players]
  ;(println "Enter the name for player #"))
