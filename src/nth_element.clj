(ns nth-element)

(defn get-nth
  [list index currentIndex currentElement]
  (if (= currentIndex index)
    currentElement
    (let [tail (rest list)
          nextIndex (inc currentIndex)
          nextElement (first tail)]
          (get-nth tail index nextIndex nextElement))
  ))

(defn nth-of
  [list index] 
  (get-nth list index 0 (first list)))
