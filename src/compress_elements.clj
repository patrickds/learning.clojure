(ns compress-elements)

(defn- drop-if-equal-previous
  [acc current]
  (let [previous (last acc)]
    (cond 
      (= previous current) acc
      :else (concat acc [current]))))

(defn compress
  [coll]
  (reduce drop-if-equal-previous '() coll))
