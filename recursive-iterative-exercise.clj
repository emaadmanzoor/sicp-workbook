; Solution for SICP (2e) Exercise 1.11
;
; A really awesome exercise on writing an
; iterative procedure; I drew a lot of
; inspiration from looking at how the
; iterative procedure for calculating the
; nth Fibonacci number maintains its state:
;
;   f(n) = f(n-1) + f(n-2)
;
; This maintains 2 state variables, a and b.
; a and b are initially f(1) and f(0), the
; base cases.
;
; With every iteration, a = a + b, b = a, so
; the trace for f(5) looks like:
;
; a b n
; 1 0 5
; 1 1 4
; 2 1 3
; 3 2 2
; 5 3 1
; 8 5 0 --> Halt! Print f(5) = b = 5
;
; Applying this same logic to our function:
;
; f(n) = |  n         n < 3
;        |
;        |  f(n-1)  +
;        |  2f(n-2) +
;        |  3f(n-3)   n >= 3
;
; Maintain state with three variables: a, b, c;
; and at every iteration, a = a + 2b + 3c, b = a
; c = b, and reduce the counter n by 1.
;
; When n < 3, return a, which is the final result.


(defn f-recursive [n]
  (if (< n 3)
    n
    (+ (f-recursive (- n 1))
       (* 2 (f-recursive (- n 2)))
       (* 3 (f-recursive (- n 3))))))

(defn f-iterative [a b c n]
  (if (< n 3)
    a
    (f-iterative (+ a (* 2 b) (* 3 c))
                 a b (- n 1))))

(println (f-recursive 10))
(println (f-iterative 2 1 0 10))
