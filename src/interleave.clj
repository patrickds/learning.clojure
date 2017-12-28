(ns interleave)

(defn interleave' [xs ys]
  (apply concat (map vector xs ys)))
