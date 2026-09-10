(ns association-facts-kotoba-parity-test
  "The IBEC catalog in .cljc and in .kotoba, field by field.

  These are not two implementations of a rule; they are one body of facts written
  twice, and the risk is transcription -- a wrong URL, a dropped field, a topic
  that lost its entry. The .cljc catalog is authored by hand; the .kotoba port is
  emitted by tools/gen_kotoba.cljs from data/datascript-tx.edn. That independence
  is the whole reason comparing them means anything, so do not 'simplify' this by
  generating both from one source.

  Every field of every entry is compared, plus the counts, topic membership and
  the coverage note, because a catalog is exactly the shape where checking a
  sample checks the entries someone already looked at.

  `:association-rule/topic` is a SET in the .cljc. A set has no order and `topic`
  is indexed by position, so both the port and the expectation below take the
  order data/datascript-tx.edn writes -- read from that file here rather than
  restated as a literal, because a literal is one more thing to forget."
  (:require [clojure.test :refer [deftest is testing]]
            [clojure.edn :as edn]
            [association.facts :as facts]
            [kotoba.compiler.core :as compiler]
            [kotoba.kir :as ir]))

(def ^:private source (slurp "src/association_facts.kotoba"))
(def ^:private kir (:kir (compiler/compile-source source :js-kotoba-v1)))
(defn- call [f & args] (ir/execute kir f (vec args)))
(defn- present [option] (when (second option) (nth option 2)))

(def ^:private slug "ibec")
(def ^:private fields
  ["id" "title" "association" "isic" "country" "kind" "url" "url-provenance"
   "established-date" "last-revised-date" "retrieved-at"])
(def ^:private kw->field
  (into {} (map (juxt identity #(keyword "association-rule" %)) fields)))
(def ^:private entries (vec (facts/spec-basis slug)))

;; The written order of each entry's topics, from the data file the port was
;; generated from -- not from `seq` on a set, which is not stable to rely on.
(def ^:private topic-order
  (mapv #(mapv name (:association-rule/topic %))
        (edn/read-string (slurp "data/datascript-tx.edn"))))

(deftest the-fixture-reads-a-real-catalog
  ;; An empty catalog compares equal to an empty port.
  (is (pos? (count entries)))
  (is (= (count entries) (count topic-order))))

(deftest every-field-of-every-entry-is-transcribed
  (is (= (count entries) (call 'entry-count slug)))
  (doseq [[i entry] (map-indexed vector entries)]
    (doseq [f fields]
      (testing (str "entry " i " / " f)
        (let [expected (get entry (kw->field f))
              expected (cond (keyword? expected) (name expected)
                             (nil? expected) nil
                             :else expected)]
          (is (= expected (present (call 'entry-field slug i f)))))))))

(deftest a-field-the-catalog-does-not-carry-is-absent-not-blank
  ;; :last-revised-date is set on exactly one entry. If the port answered every
  ;; field for every entry this test would pass while the port was wrong.
  (let [carried (keep-indexed (fn [i _] (when (present (call 'entry-field slug i "last-revised-date")) i))
                              entries)]
    (is (= (keep-indexed (fn [i e] (when (:association-rule/last-revised-date e) i)) entries)
           (seq carried))
        "the port must carry the field on exactly the entries the catalog sets it on"))
  (is (nil? (present (call 'entry-field slug 0 "no-such-field")))))

(deftest topics-are-complete-and-in-the-order-the-port-chose
  (doseq [[i names] (map-indexed vector topic-order)]
    (testing (str "entry " i)
      (is (= (count names) (call 'topic-count slug i))
          "one number for every entry is the mistake this invites")
      (is (= (set names)
             (set (map name (:association-rule/topic (nth entries i)))))
          "the written order must name exactly the set the cljc holds")
      (doseq [[t nm] (map-indexed vector names)]
        (is (= nm (present (call 'topic slug i t)))))
      (is (nil? (present (call 'topic slug i (count names))))
          "and stop there"))))

(deftest by-topic-answers-the-same-entries-at-every-index
  (doseq [t (distinct (mapcat identity topic-order))]
    (testing t
      (let [cljc (mapv :association-rule/id (facts/by-topic slug (keyword t)))]
        (is (= (count cljc) (call 'by-topic-count slug t)))
        ;; every index, not just the first: a port that answers 0 and gives up
        ;; looks correct to a test that only ever asks for 0.
        (doseq [[i id] (map-indexed vector cljc)]
          (is (= id (present (call 'by-topic-id slug t i)))))
        (is (nil? (present (call 'by-topic-id slug t (count cljc))))))))
  (is (zero? (call 'by-topic-count slug "no-such-topic")))
  (is (nil? (present (call 'by-topic-id slug "no-such-topic" 0)))))

(deftest the-coverage-note-is-the-same-sentence-on-both-faces
  ;; This drifted once already: the .cljc said the entries were "seeded with
  ;; Wikipedia citations" while the port beside it said "an official citation",
  ;; and nothing compared them. The .cljc note is computed from the catalog, so
  ;; adding an entry changes it and the port must be regenerated.
  (is (= (:note (facts/coverage [slug]))
         (present (call 'coverage-note slug)))))

(deftest an-unknown-association-is-covered-by-nothing
  (doseq [other ["zzz" ""]]
    (is (false? (call 'association-covered? other)))
    (is (zero? (call 'entry-count other)))
    (is (nil? (present (call 'entry-field other 0 "id"))))
    (is (nil? (present (call 'coverage-note other))))
    (is (nil? (facts/spec-basis other)) "and the cljc agrees")))

(deftest an-out-of-range-entry-is-refused-at-both-ends
  (doseq [i [-1 (count entries)]]
    (is (nil? (present (call 'entry-field slug i "id"))))
    (is (zero? (call 'topic-count slug i)))))

(deftest the-module-compiles-for-every-target-it-claims
  (doseq [target [:js-kotoba-v1 :wasm32-kotoba-v1 :x86_64-kotoba-v1 :aarch64-kotoba-v1]]
    (testing (name target)
      (is (some? (compiler/compile-source source target {}))))))
