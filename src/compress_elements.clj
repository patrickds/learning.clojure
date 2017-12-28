(ns compress-elements)

(defn compress
  [coll]
  (reduce (fn
    [acc current]
    (let [previous (last acc)]
      (cond 
        (= previous current) acc
        :else (concat acc [current]))))
      '() coll))
