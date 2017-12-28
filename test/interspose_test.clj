(ns interspose-test
  (:require [clojure.test :refer :all]
            [interspose :refer :all]))

(deftest test-interspose
  (testing "Interspose"
    (is (= '(1 0 2 0 3) (interspose' 0 '(1 2 3))))
    (is (= [:a :z :b :z :c :z :d] (interspose' :z [:a :b :c :d])))
    ))
