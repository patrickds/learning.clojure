(ns find-last-test
  (:require [clojure.test :refer :all]
            [find-last :refer :all]))

(deftest test-last-of
  (testing "Last of collection"
    (is (= 4 (last-of '(1 2 3 4))))
    (is (= 5 (last-of [1 2 3 4 5])))
    (is (= "d" (last-of ["b" "c" "d"])))
    ))
