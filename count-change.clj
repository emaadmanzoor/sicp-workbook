; Notes on SICP (2e) Counting Change
;
; a = amount to make with the change
; n = number of kinds of coins available
;
; Conditions:
;   a = 0 => number of ways = 1
;   a < 0 => number of ways = 0
;   n = 0 => number of ways = 0
;   else:
;     We don't use the first kind of coin:
;       n(a, n - 1)
;     We use the first kind of coin:
;       n(a - d, n)
;   d = denomination of the first kind.

(defn first-denomination
  "The denomination of the first kind of coin,
  given the total number of kinds."
  [number-of-kinds]
  (cond
    (= number-of-kinds 1) 1
    (= number-of-kinds 2) 5
    (= number-of-kinds 3) 10
    (= number-of-kinds 4) 25
    (= number-of-kinds 5) 50))

(defn count-change
  "Number of ways to make 'a' using 'n' kinds
  of coins'"
  [a n]
  (cond
    (= a 0) 1
    (or (< a 0) (= n 0)) 0
    :else (+ (count-change a (- n 1))
             (count-change (- a (first-denomination n)) n))))

(println (count-change 100 5))
