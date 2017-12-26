(ns penultimate-element-test
  (:require [clojure.test :refer :all]
            [penultimate-element :refer :all]))

(deftest test-penultimate-element
  (testing "Penultimate of collection"
    (is (= 3 (penultimate-of '(1 2 3 4))))
    (is (= 4 (penultimate-of [1 2 3 4 5])))
    (is (= "c" (penultimate-of ["b" "c" "d"])))
    ))
