(ns sum-elements-test
  (:require [clojure.test :refer :all]
            [sum-elements :refer :all]))


(deftest test-sum-of
  (testing "Sum of elements"
    (is (= 2 (sum-of [1 1])))
    (is (= 9 (sum-of '(2 3 4))))
    ))
