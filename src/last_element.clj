(ns last-element)

(defn last-index-of
  [list]
  (dec (count list)))

(defn last-of
  [list]
  (nth list (last-index-of list)))
