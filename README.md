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

`ibec.ie`'s own "About us" page did not itself state an exact
founding date (only a vague "over 30 years" reference) — both
entries here were instead directly confirmed via `en.wikipedia.org`.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on Ibec's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/association/facts.cljc` — the catalog, source of truth.
- `schema/association-rule.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

Both entries directly WebFetch-verified against `en.wikipedia.org`'s
own article: the 1993 founding (merger of FIE and CII) and the 1911
Dublin Employers' Federation (Ibec's earliest predecessor body).

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Policy text
itself remains Ibec's; this repo stores only citation metadata
(id/title/url/dates), not full text.
