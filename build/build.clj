(ns build
  (:require [cljs.build.api :as cljs]))

(def source-paths ["src"])
(def main-ns 'app.client.main)
(def output-to "target/cljs/main.js")
(def output-dir "target/cljs/out")

(def build-options
  {:main main-ns
   :output-to output-to
   :output-dir output-dir
   :optimizations :none
   :source-map true})

(defn compile! []
  (println "Compiling" main-ns "->" output-to)
  (cljs/build source-paths build-options)
  (println "Done"))

(defn watch! []
  (println "Watching" source-paths "for changes...")
  (cljs/watch source-paths build-options))

(defn -main [& args]
  (case (first args)
    "watch" (watch!)
    "compile" (compile!)
    (do
      (println "Usage: clj -M:cljs [compile|watch]")
      (compile!))))
