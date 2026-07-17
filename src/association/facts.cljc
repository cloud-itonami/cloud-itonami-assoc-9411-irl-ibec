(ns association.facts
  "Industry rule/history catalog for Ibec (Irish Business and
  Employers Confederation) -- a 45th industry-association-level
  source (see cloud-itonami-assoc-9411-sau-fsc, -9411-aut-wko for the
  first two) per ADR-2607141700 (cloud-itonami-compliance-fact-federation).
  The THIRD entry aligned to ISIC 9411 (activities of business,
  employers, and professional membership organizations). Fills
  Ireland's previously-open association-axis gap (noted honestly at
  tick 132) -- Ireland now has real, individually verified facts
  across ALL THREE axes (municipality:
  cloud-itonami-municipality-irl-dublin, tick 131; country:
  cloud-itonami-iso3166-irl statute.facts, tick 132; association:
  this entry, tick 133).

  Both entries directly WebFetch-verified against en.wikipedia.org's
  own Ibec article (ibec.ie's own 'About us' page did not itself
  state an exact founding date, only a vague 'over 30 years'
  reference): 'IBEC was founded in 1993 by the merger of the
  Federation of Irish Employers (FIE) and the Confederation of Irish
  Industry (CII).' and 'The FIE's history begins with the foundation
  of the Dublin Employers' Federation... in 1911, which was
  incorporated in 1928 as Federated Employers Ltd, renamed the
  Federated Union of Employers (FUE) in 1942... and finally renamed
  FIE in 1989.' (the 1911 founder's name incidentally encountered but
  never persisted here).

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"ibec"
   [{:association-rule/id "ibec.founding-1993-fie-cii-merger"
     :association-rule/title "Ibec founded by merger of FIE and CII (Wikipedia)"
     :association-rule/association "ibec"
     :association-rule/isic "9411"
     :association-rule/country "IRL"
     :association-rule/kind :governance-program
     :association-rule/url "https://en.wikipedia.org/wiki/Ibec"
     :association-rule/url-provenance :wikipedia-corroborated
     :association-rule/established-date "1993"
     :association-rule/retrieved-at "2026-07-17"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ibec.predecessor-dublin-employers-federation-1911"
     :association-rule/title "Dublin Employers' Federation, Ibec's earliest predecessor body (Wikipedia)"
     :association-rule/association "ibec"
     :association-rule/isic "9411"
     :association-rule/country "IRL"
     :association-rule/kind :governance-program
     :association-rule/url "https://en.wikipedia.org/wiki/Ibec"
     :association-rule/url-provenance :wikipedia-corroborated
     :association-rule/established-date "1911"
     :association-rule/retrieved-at "2026-07-17"
     :association-rule/topic #{:governance}}]})

(defn spec-basis [association] (get catalog association))

(defn coverage
  ([] (coverage (keys catalog)))
  ([associations]
   (let [have (filter catalog associations)
         missing (remove catalog associations)]
     {:requested (count associations)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-9411-irl-ibec Wave 0 (ADR-2607141700): "
                 (count (get catalog "ibec")) " Ibec entries seeded "
                 "with Wikipedia citations. "
                 "Extend `association.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))
