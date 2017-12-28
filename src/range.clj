(ns range)

(defn range'
  ([to] (range' 0 to))
  ([from to] (range' from to '()))
  ([from to coll]
    (cond
      (= from to) coll
      :else (range' (inc from) to (concat coll [from]))))
  )
