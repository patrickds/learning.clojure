(ns filter-odds)

(defn is-odd [x] (= 1 (rem x 2)))

(defn odds-of [seq] (filter is-odd seq))

