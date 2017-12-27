(ns flatten)

(defn flatten-of
  [coll]
  (let [head (first coll)
        tail (rest coll)]
  (if (sequential? head)
  (concat (flatten-of head) (flatten-of tail))
  (if (nil? head)
  []
  (concat [head] (flatten-of tail))))))
