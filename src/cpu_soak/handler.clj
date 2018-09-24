(ns cpu-soak.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn tan-atan [times] 
	(letfn [(atan- [n times] 
			(fn [] (if (> times 0) (tan- (Math/atan n) (dec times)) n)))
		(tan- [n times] 
			(fn [] (if (> times 0) (atan- (Math/tan n) (dec times)) n)))]
	(trampoline atan- 1.0M times)))


(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/tan-atan/:times" [times] 
	(let [start (System/currentTimeMillis) 
		_ (tan-atan (Long/parseLong times))] 
	(str (- (System/currentTimeMillis) start))))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
