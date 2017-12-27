(ns reverse-elements)

(defn reverse-of
  [list]
  (reduce (fn [acc current] 
    (conj acc current)) '() list))
