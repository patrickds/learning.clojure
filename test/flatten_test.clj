(ns flatten-test
  (:require [clojure.test :refer :all]
            [flatten :refer :all]))

(deftest test-flattten
  (testing "Flatten collection"
    (is (= '(1) (flatten-of '((1)) )))
    (is (= '(1) (flatten-of '(((1))) )))
    (is (= '(1 2) (flatten-of '((1 2)) )))
    (is (= '(1 2) (flatten-of '(((1 2))) )))
    (is (= '(:a) (flatten-of '((((:a)))) )))
    (is (= '(1 2 3 4 5 6) (flatten-of '((1 2) 3 [4 [5 6]]) )))
    (is (= ["a" "b" "c"] (flatten-of ["a" ["b"] "c"] )))
    ))
