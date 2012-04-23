; Solution for SICP (2e) Exercise 1.8
;
; Newton's method of cube roots is based on
; the fact that if y is an approximation to
; the cube root of x, then a better approximation
; is given by the value:
;   (x/y^2 + 2y)/2
; Use this formula to implement a cube root
; procedure analogous to the square root one.

(defn improve
  "Improves the guess for the cube root"
  [guess x]
  (/ ( + (/ x (* guess guess)) (* 2.0 guess)) 3.0))

(defn good-enough?
  "Tests if the cube-root guess is good"
  [oldguess guess]
  (<
    (if (< oldguess guess)
      (/ guess oldguess)
      (/ oldguess guess))
    1.001))

(defn cube-root
  "Calculates the cube root"
  [oldguess guess x]
  (if (good-enough? oldguess guess)
    guess
    (cube-root guess (improve guess x) x)))
