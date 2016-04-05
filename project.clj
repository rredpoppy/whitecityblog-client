(defproject whitecityblog-client "1.0.0"
  :description "Client script for the WhiteCity City Blog"
  :url "http://whitecitycode.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.5.3"

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [racehub/om-bootstrap "0.6.1"]
                 [org.clojure/clojurescript "1.7.170"]
                 [cljsjs/markdown "0.6.0-beta1-0"]
                 ;[org.webjars/jquery "2.2.2"]
                 ;[org.webjars/bootstrap "3.3.6"]
                 [org.clojure/core.async "0.2.374"
                  :exclusions [org.clojure/tools.reader]]
                 ;[sablono "0.3.6"]
                 [org.omcljs/om "0.9.0"]]

  :plugins [[lein-figwheel "0.5.0-6"]
            [lein-cljsbuild "1.1.2" :exclusions [[org.clojure/clojure]]]]
  :hooks [leiningen.cljsbuild]
  :source-paths ["src"]

  :clean-targets ^{:protect false} ["compiled"]

  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src"]

                ;; If no code is to be run, set :figwheel true for continued automagical reloading
                :figwheel {:on-jsload "whitecityblog-client.core/on-js-reload"}

                :compiler {:main whitecityblog-client.core
                           :output-to "compiled/whitecityblog-client-dev.js"
                           :output-dir "compiled/out-dev"
                           :source-map-timestamp true}}
               ;; This next build is an compressed minified build for
               ;; production. You can build this with:
               ;; lein cljsbuild once min
               {:id "min"
                :source-paths ["src"]
                :compiler {:output-to "compiled/whitecityblog-client.js"
                           :main whitecityblog-client.core
                           :optimizations :advanced
                           :pretty-print false}}]}

  :figwheel {;; :http-server-root "public" ;; default and assumes "resources"
             })
