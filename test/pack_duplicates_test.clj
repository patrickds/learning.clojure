(ns pack-duplicates-test
  (:require [clojure.test :refer :all]
            [pack-duplicates :refer :all]))

(deftest test-pack-duplicates
  (testing "Pack duplicates"
    (is (= '((1)) (pack-duplicates '(1))))
    (is (= '((1 1)) (pack-duplicates '(1 1))))
    (is (= '((1) (2)) (pack-duplicates '(1 2))))
    (is (= '((1) (2) (1)) (pack-duplicates '(1 2 1))))
    (is (= '((1 1) (2) (1 1 1) (3 3)) (pack-duplicates [1 1 2 1 1 1 3 3])))
    (is (= '(([1 2] [1 2]) ([3 4])) (pack-duplicates [[1 2] [1 2] [3 4]])))
    ))
