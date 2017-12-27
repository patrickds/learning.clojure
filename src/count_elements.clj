(ns count-elements)

(defn count-of
  [list]
  (reduce 
    (fn [val coll] (inc val))
    0 list))
