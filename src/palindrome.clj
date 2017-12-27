(ns palindrome)

(defn is-palindrome
  [coll] 
  (= (seq coll) (reverse coll)))
