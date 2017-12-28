; Thread first macro (-> [x & froms]) sends the first expression as the first argument to the next form
; and sends the result subsequently, making a pipeline!

; The following transforms are equivalent

(defn transform [person]
  (update (assoc person :hair-color :gray) :age inc))

(defn transform' [person]
  (-> person
    (assoc ,,, :hair-color :gray)
    (update ,,, :age inc)))

(def person {:name "Socrates", :age 39})

(= (transform person) (transform' person))
;= true

; the ,,, is a hint to where the result of the previous expression will be placed
; NOTE: ,,, is considered whitespace in clojure

; ------------------------------------------------------------------------------------

; Thread last macro (->> [x & forms]) exactly like the previous but inserts the first expression as 
; the last argument.

(defn calculate []
  (reduce + (map #(* % %) (filter odd? (range 10)))))

(defn calculate' []
  (->> (range 10)
       (filter odd? ,,,)
       (map #(* % %) ,,,)
       (reduce + ,,,)))

(= (calculate) (calculate'))
;= true

; ------------------------------------------------------------------------------------

; This is how thread first and thread last would evaluate the same expression

(->> 5 (+ 3) (/ 2) (- 1))
;= (+ 3 5)
;= (/ 2 (+ 3 5))
;= (- 1 (/ 2 (+ 3 5)))
;= (- 1 (/ 2 8))
;= (- 1 1/4)
;= (3/4)

(-> 5 (+ 3) (/ 2) (- 1))
;= (+ 5 3)
;= (/ (+ 5 3) 2)
;= (- (/ (+ 5 3) 2) 1)
;= (- (/ 8 2) 1)
;= (- 4 1)
;= 3
