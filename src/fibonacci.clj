(ns fibonacci)

(defn smallFib [n]
  (if (= n 0)
  '()
  '(1)))

(defn largeFib
  [n]
  (reduce (fn 
    [acc _]
    (let [tail (last acc)
          penultimate (nth acc (- (count acc) 2))
          nextFib (+ tail penultimate)]
    (concat acc [nextFib])))
  '(1 1) (range 2 n)))

(defn fibonacci
  [n]
  (if (< n 2)
  (smallFib n)
  (largeFib n)))
