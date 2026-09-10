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

  PROVENANCE, by tier -- read `:association-rule/url-provenance`, not
  the title, when you need to know how far a fact has been checked:

  - `:official-ibec-ie` / `:official-irishstatutebook-ie` -- Ibec's own
    publication, or the Irish State's. Fetched and read 2026-09-06.
  - `:wikipedia-corroborated` -- the two founding-history entries. Kept
    on this tier because ibec.ie's own 'About us' page does not state a
    founding date (only a vague 'over 30 years'), so there is no
    official source to promote them to.
  - `:official-ibec-ie-self-declared` -- Ibec asserts it, and nothing
    else here does. The EU Transparency Register id is on this tier:
    the register exposes no stable per-organisation URL (both the
    ec.europa.eu and transparency-register.europa.eu deep links 404,
    and the CSV export is 403), so the number is Ibec's claim about
    itself, NOT a register-side confirmation. Do not cite it as one.

  Personal names are deliberately absent. ibec.ie's governance and
  about pages do name the CEO and two presidents; `organization.edn`
  records institutional office titles only, and this catalog keeps to
  the same rule.

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
     :association-rule/topic #{:governance}}
    {:association-rule/id "ibec.rules-govern-confederation"
     :association-rule/title "The Ibec Rules govern the confederation, setting its structures and the procedures for appointment to the National Council and the Ibec Board (ibec.ie)"
     :association-rule/association "ibec"
     :association-rule/isic "9411"
     :association-rule/country "IRL"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ibec.ie/about-us/our-governance/ibec-structures"
     :association-rule/url-provenance :official-ibec-ie
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ibec.rules-document-registered-2022-08-22"
     :association-rule/title "Ibec Rules, published by Ibec as a 36-page document labelled registered 22 08 2022 (ibec.ie)"
     :association-rule/association "ibec"
     :association-rule/isic "9411"
     :association-rule/country "IRL"
     :association-rule/kind :governance-program
     :association-rule/url "https://cdn.ibec.ie/-/media/documents/about-us/ibec-rules-registered-22-08-2022.pdf?rev=e350c0a7c6dd49e3b979730f42b90543"
     :association-rule/url-provenance :official-ibec-ie
     :association-rule/last-revised-date "2022-08-22"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance}}
    {:association-rule/id "ibec.clg-company-under-companies-act-2014"
     :association-rule/title "Ibec CLG is a company under the Companies Act 2014, established by the Irish Business and Employers Confederation (ibec.ie)"
     :association-rule/association "ibec"
     :association-rule/isic "9411"
     :association-rule/country "IRL"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ibec.ie/about-us/our-governance/ibec-structures"
     :association-rule/url-provenance :official-ibec-ie
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance :corporate-form}}
    {:association-rule/id "ibec.companies-act-2014-number-38"
     :association-rule/title "Companies Act 2014 (Number 38 of 2014), the statute Ibec CLG is constituted under (Irish Statute Book)"
     :association-rule/association "ibec"
     :association-rule/isic "9411"
     :association-rule/country "IRL"
     :association-rule/kind :statute
     :association-rule/url "https://www.irishstatutebook.ie/eli/2014/act/38/enacted/en/html"
     :association-rule/url-provenance :official-irishstatutebook-ie
     :association-rule/established-date "2014"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:corporate-form :statute}}
    {:association-rule/id "ibec.trade-associations-under-rules-and-byelaws"
     :association-rule/title "Over 39 trade associations, established under the Ibec Rules and Byelaws for consultation, representation and the provision of Ibec services (ibec.ie)"
     :association-rule/association "ibec"
     :association-rule/isic "9411"
     :association-rule/country "IRL"
     :association-rule/kind :membership-rule
     :association-rule/url "https://www.ibec.ie/about-us/trade-associations"
     :association-rule/url-provenance :official-ibec-ie
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance :membership}}
    {:association-rule/id "ibec.eu-transparency-register-self-declared"
     :association-rule/title "Ibec states it maintains a presence on the EU Transparency Register under identification number 479468313744-50 (ibec.ie, self-declared; not verified against the register)"
     :association-rule/association "ibec"
     :association-rule/isic "9411"
     :association-rule/country "IRL"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ibec.ie/about-us/our-regions-and-brussels-office/our-brussels-office"
     :association-rule/url-provenance :official-ibec-ie-self-declared
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:eu-representation}}]})

(defn spec-basis [association] (get catalog association))

(defn- provenance-tier
  "Which of the three tiers in the namespace docstring this entry sits on."
  [entry]
  (let [p (name (:association-rule/url-provenance entry))]
    (cond (= p "wikipedia-corroborated") :corroborated
          (re-find #"self-declared$" p)  :self-declared
          (re-find #"^official-" p)      :official
          :else                          :unknown)))

(defn note-for
  "The coverage note, COMPUTED from the catalog rather than written beside it.

  Written notes drift: before this was computed, the .cljc said the entries were
  \"seeded with Wikipedia citations\" while the .kotoba port beside it said \"an
  official citation\", and nothing compared the two. Deriving the counts means
  adding an entry changes this string, and the parity test then requires the port
  to be updated with it."
  [association]
  (let [entries (get catalog association)
        n       (count entries)
        tally   (frequencies (map provenance-tier entries))
        cnt     #(get tally % 0)]
    (str "cloud-itonami-assoc-9411-irl-ibec Wave 0 (ADR-2607141700): "
         n " Ibec entries -- "
         (cnt :official) " from Ibec's or the Irish State's own publication, "
         (cnt :corroborated) " Wikipedia-corroborated, "
         (cnt :self-declared) " self-declared by Ibec and not confirmed against the issuing register. "
         "Extend `association.facts/catalog`, never fabricate an id/url.")))

(defn coverage
  ([] (coverage (keys catalog)))
  ([associations]
   (let [have (filter catalog associations)
         missing (remove catalog associations)]
     {:requested (count associations)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (note-for "ibec")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))
