(ns association.facts-test
  (:require [clojure.test :refer [deftest is]]
            [association.facts :as facts]))

(deftest ibec-has-spec-basis
  (let [sb (facts/spec-basis "ibec")]
    (is (= 2 (count sb)))
    (is (every? #(= "9411" (:association-rule/isic %)) sb))
    (is (every? #(= "IRL" (:association-rule/country %)) sb))))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "wko")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["ibec" "wko"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["wko"] (:missing-associations c)))))

(deftest by-topic-filters
  (is (= 2 (count (facts/by-topic "ibec" :governance))))
  (is (empty? (facts/by-topic "ibec" :labor)))
  (is (empty? (facts/by-topic "wko" :governance))))
