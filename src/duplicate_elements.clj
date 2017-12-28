(ns duplicate-elements)

(defn duplicate
  [coll]
  (reduce (fn
            [acc current]
            (concat acc [current current]))
          '() coll))
