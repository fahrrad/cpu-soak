(defproject cpu-soak "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler cpu-soak.handler/app}
  :uberjar-name "cpu_soak.jar"
  :profiles
  {:dev {:dependencies [[com.taoensso/tufte "2.0.1"]
			[criterium "0.4.4"]
			[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
