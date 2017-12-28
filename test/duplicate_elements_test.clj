(ns duplicate-elements-test
  (:require [clojure.test :refer :all]
            [duplicate-elements :refer :all]))

(deftest test-duplicate-elements
  (testing "Duplicates elements"
    (is (= '(1 1 2 2) (duplicate '(1 2))))
    (is (= '([1 2] [1 2] [3 4] [3 4]) (duplicate [[1 2] [3 4]])))
    (is (= '(:a :a :a :a :b :b :b :b) (duplicate '(:a :a :b :b))))
    ))
