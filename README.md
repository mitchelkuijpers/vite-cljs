# vite cljs

This is a playground to see how well we can integrate vite and clojurescript.

## ClojureScript (programmatic build)

Compile once:

```bash
clj -M:cljs compile
```

Watch and recompile on changes:

```bash
clj -M:cljs watch
```

Entry namespace: `app.client.main` (`src/app/client/main.cljs`)

Output:
- `target/cljs/main.js`
- `target/cljs/out`
