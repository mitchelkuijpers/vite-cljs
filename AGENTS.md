# AGENTS.md

## Session learnings (2026-02-27)

### Tooling bootstrap
- This repo uses `mise` via `mise.toml`:
  - `clojure = "1.12.4.1602"`
  - `java = "26"`
  - `node = "24"`
- In fresh environments, `mise` may refuse to run tools until the repo is trusted.
- Required first-run commands:

```bash
mise trust
mise install
```

### Clojure CLI in this environment
- `clj` failed here due to missing `rlwrap`.
- `clojure` works and should be used for automation scripts in this repo:

```bash
mise exec -- clojure -Sdescribe
```

### Basic ClojureScript pipeline (programmatic build)
- We chose Option 3 (`cljs.build.api`) as step 1 toward eventual Vite plugin integration.
- Build entrypoint namespace: `app.client.main` at `src/app/client/main.cljs`.
- Build script file: `build/build.clj`.
- Build outputs:
  - `target/cljs/main.js`
  - `target/cljs/out`

Commands:

```bash
mise exec -- clojure -M:cljs compile
mise exec -- clojure -M:cljs watch
```

### Repo hygiene
- `.gitignore` includes CLJS/dev artifacts:
  - `target/`
  - `.clj-kondo/`
  - `.cpcache/`
  - `.lsp/`
  - `node_modules/`, `dist/`

### Git notes from this session
- Vite setup commit was made separately from `.aishell/Dockerfile` changes.
- Dockerfile change was a single package add: `tmux`.
