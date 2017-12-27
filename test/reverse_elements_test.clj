(ns reverse-elements-test
  (:require [clojure.test :refer :all]
            [reverse-elements :refer :all]))

(deftest test-reverse-elements
  (testing "Reverse elements"
    (is (= '(3 2 1) (reverse-of '(1 2 3))))
    (is (= '(4 3 2 1) (reverse-of '(1 2 3 4))))
    (is (= [[1 2] [3 4]] (reverse-of [[3 4] [1 2]])))
    ))
