(ns filter-odds-test
  (:require [clojure.test :refer :all]
            [filter-odds :refer :all]))

(deftest test-odds-of
  (testing "Odds of"
    (is (= '(1 3 5) (odds-of '(1 2 3 4 5))))
    (is (= '(1) (odds-of '(4 2 1 6))))
    ))
