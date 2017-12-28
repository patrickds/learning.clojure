(ns compress-elements-test
  (:require [clojure.test :refer :all]
            [compress-elements :refer :all]))

(deftest test-compress-elements
  (testing
    (is (= '(1 2 3) (compress '(1 2 3))))
    (is (= '(1 2 3 2 3) (compress '(1 1 2 3 3 2 2 3))))
    (is (= '([1 2] [3 4] [1 2]) (compress [[1 2] [1 2] [3 4] [1 2]])))
    (is (= "Leroy" (apply str (compress "Leeeeeerrroyyy"))))
    ))

