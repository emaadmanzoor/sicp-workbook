; Notes on SICP (2e) Exercise 1.9
;
; This is the first time I've written
; a recursive addition procedure,
; preferring to use the traditional
; binary operator that's so yesterday.

(defn add-recursive
  "Adds 2 numbers in a recursive process"
  [a b]
  (if (= a 0)
    b
    (inc (add-recursive (dec a) b))))

(defn add-iterative
  "Adds 2 numbers in an iterative process"
  [a b]
  (if (= a 0)
    b
    (add-iterative (dec a) (inc b))))

(println (add-recursive 4 5))
(println (add-iterative 4 5))
