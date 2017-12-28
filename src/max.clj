(ns max)

(defn max' [& args]
  (reduce (fn [acc current]
    (cond
      (> current acc) current
      :else acc)
    ) Integer/MIN_VALUE args))
