(ns min-test
  (:require [clojure.test :refer :all]
            [min :refer :all]))

(deftest test-min
  (testing "Min"
    (is (= 1 (min' 1 2 3 4)))
    (is (= 2 (min' 4 2 3 4)))
    (is (= -82 (min' 4 2 3 -82)))
    ))
