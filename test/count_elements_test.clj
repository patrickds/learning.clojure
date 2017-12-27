(ns count-elements-test
  (:require [clojure.test :refer :all]
            [count-elements :refer :all]))

(deftest test-count-of
  (testing "Count of collection"
    (is (= 1 (count-of [1])))
    (is (= 2 (count-of [2 1])))
    (is (= 3 (count-of '(:a :b :c))))
    (is (= 18 (count-of "Weeeee I'm lenghty")))
    ))
