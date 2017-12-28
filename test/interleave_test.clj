(ns interleave-test
  (:require [clojure.test :refer :all]
            [interleave :refer :all]))

(deftest test-interleave
  (testing "Interleave"
    (is (= '(1 :a 2 :b 3 :c) (interleave' [1 2 3] [:a :b :c])))
    (is (= '(1 3 2 4) (interleave' [1 2] [3 4 5 6])))
    (is (= [1 5] (interleave' [1 2 3 4] [5])))
    ))
