(ns walkthroughs.failjure
  (:require [failjure.core :as f]))

(defn http-get [url]
  "A fake http get"
  (condp = url
    "https://users/patrick" {:body {:name "Patrick" :age 24 :cats-url "https://users/patrick/cats"}}
    "https://users/patrick/cats" {:body [{:name "Smuffles" :color :silver} {:name "Flufkins" :color :black}]}
    (throw (ex-info "Resource Not Found" {:code 404}))))

(defn format-info-ex [info]
  (let [cats-number (count info)]
    (str "This user has " cats-number " cats:\n" info)))

;= Exception based solution

(defn get-cats-ex [username]
  (-> (str "https://users/" username)
    http-get
    :body
    :cats-url
    http-get
    :body))

(defn get-user-info-ex [username]
  (try
    (-> username
      get-cats-ex
      format-info-ex
      println)
    (catch Exception e "User not found")))

; (get-user-info-ex "patrick") ;= Works
; (get-user-info-ex "patricks") ;= Shows exception message


;= Error monad based solution

(defn get-cats [username]
  (try
    (-> (str "https://users/" username)
      http-get
      :body
      :cats-url
      http-get
      :body)
    (catch Exception e (f/fail "User not found"))))

(defn get-user-info [username]
  (f/ok-> username
    get-cats
    format-info))

(defn main []
  (let [user-info (get-user-info "patricks")]
    (cond
      (f/failed? user-info) (-> user-info f/message println)
      :else (println user-info))))

(main)
