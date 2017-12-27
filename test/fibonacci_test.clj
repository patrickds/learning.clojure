(ns fibonacci-test
  (:require [clojure.test :refer :all]
            [fibonacci :refer :all]))

(deftest test-fibonacci
  (testing "Fibonacci"
    (is (= '() (fibonacci 0)))
    (is (= '(1) (fibonacci 1)))
    (is (= '(1 1) (fibonacci 2)))
    (is (= '(1 1 2) (fibonacci 3)))
    (is (= '(1 1 2 3) (fibonacci 4)))
    (is (= '(1 1 2 3 5 8 13) (fibonacci 7)))
    ))
