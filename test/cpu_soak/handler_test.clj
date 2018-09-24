(ns cpu-soak.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
           [cpu-soak.handler :refer :all]))

(deftest tan-atan-test
	(testing "tan atan reverses == 1"
		(is (< (Math/abs (double (- 1.0 (tan-atan 200)))) 0.000001))))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello World"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
