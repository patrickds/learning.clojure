(ns palindrome-test
  (:require [clojure.test :refer :all]
            [palindrome :refer :all]))

(deftest test-is-palindrome
  (testing "Is palindrome"
    (is (true? (is-palindrome "a")))
    (is (false? (is-palindrome "a b")))
    (is (true? (is-palindrome "a b a")))
    (is (false? (is-palindrome "a b c")))
    (is (true? (is-palindrome '(1 2 3 2 1))))
    ))
