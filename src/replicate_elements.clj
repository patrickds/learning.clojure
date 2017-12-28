(ns replicate-elements)

(defn replicate [coll n]
  (reduce #(concat %1 (repeat n %2))
    '() coll))
