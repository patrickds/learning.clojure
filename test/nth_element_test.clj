(ns nth-element-test
  (:require [clojure.test :refer :all]
    [nth-element :refer :all]))

(deftest nth-of-test
  (testing "Nth element of collection"
    (is (= 3 (nth-of '(7 4 3 9 5) 2)))
    (is (= [4 5] (nth-of [1 2 10 3 [4 5] 6] 4)))
    ))
