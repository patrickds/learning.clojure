(ns pack-duplicates)

(defn pack-duplicates
  [coll]
  (partition-by identity coll))
