(ns nth-element)

(defn nth-of
  [list index]
  (if (= index 0)
    (first list)
    (nth-of (rest list) (dec index))))
