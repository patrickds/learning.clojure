(ns filter-upper-case-test
  (:require [clojure.test :refer :all]
            [filter-upper-case :refer :all]))

(deftest test-filter-upper-case
  (testing "Filter upper case"
    (is (= "HLOWRD" (upper-case-from "HeLlO, WoRlD!")))
    (is (empty? (upper-case-from "nothing")))
    (is (= "AZ" (upper-case-from "$#A(*&987Zf")))
    ))
