# cloud-itonami-assoc-9411-irl-ibec

Industry rule/history catalog for **Ibec** (Irish Business and
Employers Confederation) — the THIRD entry aligned to **ISIC 9411**
(activities of business, employers, and professional membership
organizations), alongside
[`-9411-sau-fsc`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-sau-fsc)
(Saudi Arabia) and
[`-9411-aut-wko`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-aut-wko)
(Austria). Part of the
[`cloud-itonami`](https://github.com/cloud-itonami) compliance-fact
family (ADR-2607141700, `cloud-itonami-compliance-fact-federation`,
in `com-junkawasaki/root`).

## Sourcing note

This repo fills Ireland's previously-open association-axis gap (noted
honestly at tick 132). Ireland now has real, individually verified
facts across all three axes: municipality
([`cloud-itonami-municipality-irl-dublin`](https://github.com/cloud-itonami/cloud-itonami-municipality-irl-dublin)),
country
([`cloud-itonami-iso3166-irl`](https://github.com/cloud-itonami/cloud-itonami-iso3166-irl)),
and association (this repo).

**Read `:association-rule/url-provenance`, not the title, when you need
to know how far a fact has been checked.** There are three tiers, and
the catalog's own coverage note counts them:

| Tier | Provenance | Means |
|---|---|---|
| official | `:official-ibec-ie`, `:official-irishstatutebook-ie` | Ibec's own publication, or the Irish State's |
| corroborated | `:wikipedia-corroborated` | no official source states it |
| self-declared | `:official-ibec-ie-self-declared` | Ibec asserts it and nothing else here does |

The two founding-history entries stay on the **corroborated** tier
because `ibec.ie`'s own "About us" page does not state a founding date
(only a vague "over 30 years"), so there is no official source to
promote them to.

The EU Transparency Register id (`479468313744-50`) is on the
**self-declared** tier. Ibec publishes that number about itself; the
register exposes no stable per-organisation URL to check it against —
measured 2026-09-06, the `ec.europa.eu` and
`transparency-register.europa.eu` deep links both 404 and the CSV
export is 403. It is therefore Ibec's claim, **not** a register-side
confirmation, and must not be cited as one. A test fails if that entry
is ever moved off the self-declared tier without a real register URL.

Every URL in the catalog was fetched on 2026-09-06 and returned 2xx,
and each entry's claim was matched against the phrasing on the page it
cites. One caveat worth stating: the Ibec Rules PDF is a **36-page
scanned document with no extractable text**, so what is recorded about
it is its publication and Ibec's own label for it ("Ibec Rules
registered 22 08 2022"), not anything read out of its body.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on Ibec's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/association/facts.cljc` — the catalog, source of truth,
  authored by hand.
- `schema/association-rule.edn` — DataScript schema.
- `data/datascript-tx.edn` — the same catalog as DataScript tx-data
  (query this alongside other `cloud-itonami`/`etzhayyim`
  compliance-fact sources via `com-junkawasaki/root`'s
  `scripts/compliance-fact-query.cljs`).
- `src/association_facts.kotoba` — the Kotoba port, which reaches the
  oracle, wasm and both native ISAs that the `.cljc` cannot.
  **Generated — do not edit by hand:**

  ```
  kbb --backend sci tools/gen_kotoba.cljk
  ```

The `.cljc` is written by hand and the `.kotoba` is generated from the
`.edn`, so the two faces
`test/association_facts_kotoba_parity_test.clj` compares are produced
independently. That is the only reason comparing them means anything;
do not "simplify" it by generating both from one source.

## Tests

```
kbb -M:test     # catalog + cljc/kotoba parity, incl. all four compile targets
kbb -M:lint
```

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Policy text
itself remains Ibec's; this repo stores only citation metadata
(id/title/url/dates), not full text.
