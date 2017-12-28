(ns interspose)

(defn intersposse' [x xs]
  (drop-last (reduce #(conj %1 %2 x) [] xs)))

(defn interspose' [x xs]
  (->> xs
    (reduce #(conj %1 %2 x) [])
    (drop-last)))
