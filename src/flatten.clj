(ns flatten)

(defn flatten-of
  [[head & tail]]
  (cond
    (sequential? head) (concat (flatten-of head) (flatten-of tail))
    (some? head) (cons head (flatten-of tail))
    :else '() ))
