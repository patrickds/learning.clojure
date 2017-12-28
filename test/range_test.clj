(ns range-test
  (:require [clojure.test :refer :all]
            [range :refer :all]))

(deftest test-range
  (testing "Range"
    (is (= '(4 5 6) (range' 4 7)))
    (is (= '(1 2 3 4) (range' 1 5)))
    (is (= '(0 1 2 3 4) (range' 5)))
    (is (= '(0) (range' 1)))
    (is (= '() (range' 0)))
    ))
