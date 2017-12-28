(ns replicate-elements-test
  (:require [clojure.test :refer :all]
            [replicate-elements :refer :all]))

(deftest test-replicate-elements
  (testing "Replicate elements"
    (is (= '(1 2 3) (replicate [1 2 3] 1)))
    (is (= '(1 1 2 2 3 3) (replicate [1 2 3] 2)))
    (is (= '([1 2] [1 2] [3 4] [3 4]) (replicate '([1 2] [3 4]) 2)))))
