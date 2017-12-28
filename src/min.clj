(ns min
  (:require [max :refer :all]))

(defn min' [& args]
  (->> args
    (map -)
    (apply max')
    (-)))
