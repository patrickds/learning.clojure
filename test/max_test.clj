(ns max-test
  (:require [clojure.test :refer :all]
            [max :refer :all]))

(deftest test-max
  (testing "Max"
    (is (= 1 (max' 1)))
    (is (= 2 (max' 1 2)))
    (is (= 3 (max' 1 3 2)))
    (is (= 8 (max' 1 8 3 4)))
    (is (= 67 (max' 45 67 11)))
    ))
