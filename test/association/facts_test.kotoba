(ns association.facts-test
  (:require [clojure.test :refer [deftest is]]
            [association.facts :as facts]))

(deftest ibec-has-spec-basis
  (let [sb (facts/spec-basis "ibec")]
    (is (= 8 (count sb)))
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
  (is (= 6 (count (facts/by-topic "ibec" :governance))))
  (is (= 2 (count (facts/by-topic "ibec" :corporate-form))))
  (is (= 1 (count (facts/by-topic "ibec" :statute))))
  (is (= 1 (count (facts/by-topic "ibec" :membership))))
  (is (= 1 (count (facts/by-topic "ibec" :eu-representation))))
  (is (empty? (facts/by-topic "ibec" :labor)))
  (is (empty? (facts/by-topic "wko" :governance))))

(deftest every-entry-carries-a-url-and-a-provenance-tier
  ;; The point of this catalog is the citation. An entry without one is a claim
  ;; with nothing behind it, which is the exact failure the repo forbids.
  (doseq [e (facts/spec-basis "ibec")]
    (is (re-matches #"https://\S+" (:association-rule/url e))
        (str (:association-rule/id e) " must cite an https URL"))
    (is (contains? #{:official :corroborated :self-declared}
                   (#'facts/provenance-tier e))
        (str (:association-rule/id e) " must sit on a known provenance tier"))))

(deftest the-coverage-note-counts-the-catalog-it-is-attached-to
  ;; The note used to be prose written beside the catalog and went stale; it is
  ;; now derived, so this pins the derivation rather than the sentence.
  (let [note (:note (facts/coverage ["ibec"]))
        n    (count (facts/spec-basis "ibec"))]
    (is (re-find (re-pattern (str "\\b" n " Ibec entries\\b")) note))
    (is (re-find #"5 from Ibec's or the Irish State's own publication" note))
    (is (re-find #"2 Wikipedia-corroborated" note))
    (is (re-find #"1 self-declared" note)
        "the EU Transparency Register id is Ibec's claim about itself, and the note must keep saying so")))

(deftest the-self-declared-entry-does-not-pose-as-register-verified
  ;; The register exposes no stable per-organisation URL, so nothing here may
  ;; cite one. If someone later finds a real register URL they must also move the
  ;; provenance off the self-declared tier -- this fails until they do.
  (let [e (first (filter #(= "ibec.eu-transparency-register-self-declared"
                             (:association-rule/id %))
                         (facts/spec-basis "ibec")))]
    (is (some? e))
    (is (= :official-ibec-ie-self-declared (:association-rule/url-provenance e)))
    (is (re-find #"(?i)ibec\.ie" (:association-rule/url e))
        "the citation is Ibec's own page, not the register")
    (is (not (re-find #"(?i)transparency-register\.europa\.eu|ec\.europa\.eu"
                      (:association-rule/url e))))))
