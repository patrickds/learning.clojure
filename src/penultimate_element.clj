(ns penultimate-element)

(defn penultimate-of
  [list] 
  ((comp second reverse) list))
