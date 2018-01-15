(ns event-sourcing-playground
  (:require [failjure.core :as f]))

;= UTILS
(defn next-uuid [] "7dc78351-115e-4b01-aab3-3b20a3f8367e") ;(str (java.util.UUID/randomUUID)))
(defn now [] (java.util.Date.))

;= STORE
(defprotocol EventStore
  (load-events [store])
  (save-event! [store event]))

(defprotocol EventsPrinter
  (pprint-events [source]))

(defrecord InMemoryStore [state]
  EventStore
  (load-events [store] (sort-by :created-at @(:state store)))
  (save-event! [store event] (swap! (:state store) conj event))
  EventsPrinter
  (pprint-events [store]
    (doseq [event (load-events store)]
      (clojure.pprint/pprint event))))

(def in-memory-store (->InMemoryStore (atom '())))
; (load-events in-memory-store)
; (save-event! in-memory-store (create-task-command "oie"))
; (pprint-events in-memory-store)

;= COMMANDS
(defn create-task-command [name]
  {:type :task-created
   :created-at (now)
   :attrs {:task/name name
           :task/id (next-uuid)
           :task/status :active}})

(declare list-all-tasks)
(defn do-task-command [id]
  (let [tasks (list-all-tasks)]
    (cond
      (contains? tasks id)
      {:type :task-done
       :created-at (now)
       :attrs {:task/id id
               :task/status :completed}}
      :else (f/fail "Task not found"))))

(defn undo-task-command [id]
  {:type :task-undone
   :created-at (now)
   :attrs {:task/id id
           :task/status :active}})

(defn edit-task-command [id name]
  {:type :task-edited
   :created-at (now)
   :attrs {:task/id id
           :task/name name}})

(defn delete-task-command [id]
  {:type :task-deleted
   :created-at (now)
   :attrs {:task/id id}})

;= SERVICE
(def save-in-memory! (partial save-event! in-memory-store))

(defn create-task! [name]
  (-> name
      create-task-command
      save-in-memory!))

(defn do-task! [id]
  (let [result (f/ok-> id
                       do-task-command
                       save-in-memory!)]
    (cond
      (f/failed? result) (f/message result)
      :else result)))

(defn undo-task! [id]
  (-> id
      undo-task-command
      save-in-memory!))

(defn edit-task! [id name]
  (-> (edit-task-command id name)
      save-in-memory!))

(defn delete-task! [id]
  (-> id
      delete-task-command
      save-in-memory!))

(declare list-completed-tasks)
(defn delete-completed-tasks! []
  (->> (list-completed-tasks)
       (map first)
       (map delete-task!)))

;= REDUCERS

(defn reduce-task-created [acc event]
  (let [{{task-name :task/name
          task-id   :task/id
          task-status :task/status} :attrs} event]
    (assoc-in acc [task-id] {:task-name task-name
                             :task-id task-id
                             :task-status task-status})))

(defn reduce-task-done [acc event]
  (let [{{task-status :task/status
          task-id     :task/id} :attrs} event]
    (assoc-in acc [task-id :task-status] task-status)))

(defn reduce-task-undone [acc event]
  (let [{{task-status :task/status
          task-id     :task/id} :attrs} event]
    (assoc-in acc [task-id :task-status] task-status)))

(defn reduce-task-edited [acc event]
  (let [{task-name :task/name
         task-id   :task/id} (get event :attrs)]
    (assoc-in acc [task-id :task-name] task-name)))

(defn reduce-task-deleted [acc event]
  (let [{task-id :task/id} (get event :attrs)]
    (dissoc acc task-id)))

;= QUERIES
(defn list-all-tasks []
  (reduce (fn [acc current]
            (let [task-id (get-in current [:attrs :task/id])]
              (condp = (:type current)
                :task-created (reduce-task-created acc current)
                :task-done (reduce-task-done acc current)
                :task-undone (reduce-task-undone acc current)
                :task-edited (reduce-task-edited acc current)
                :task-deleted (reduce-task-deleted acc current)
                acc))) {} (load-events in-memory-store)))

(defn is-task-completed [task-entry]
  (let [task (second task-entry)
        task-status (:task-status task)]
    (= task-status :completed)))

(defn list-completed-tasks []
  (filter is-task-completed (list-all-tasks)))

(defn list-active-tasks []
  (filter (complement is-task-completed) (list-all-tasks)))

; (create-task! "Do Supermaket")
; (do-task! "8dc78351-115e-4b01-aab3-3b20a3f8367e")
; (edit-task! "8dc78351-115e-4b01-aab3-3b20a3f8367e" "Pls do supermarket otherwise I'll starve :(")

(create-task! "Buy milk")
(do-task! "8dc78351-115e-4b01-aab3-3b20a3f8367e")
; (edit-task! "7dc78351-115e-4b01-aab3-3b20a3f8367e" "Buy eggs")
; (delete-task! "7dc78351-115e-4b01-aab3-3b20a3f8367e")
; (undo-task! "7dc78351-115e-4b01-aab3-3b20a3f8367e")
(load-events in-memory-store)

; (delete-completed-tasks!)
(list-all-tasks)
; (list-completed-tasks)
; (list-active-tasks)
