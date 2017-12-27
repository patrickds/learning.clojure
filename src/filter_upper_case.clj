(ns filter-upper-case)

(defn upper-case-from
  [s] 
  (apply str (filter #(Character/isUpperCase %) s)))
