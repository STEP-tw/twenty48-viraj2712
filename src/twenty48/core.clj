(ns twenty48.core
  (:gen-class))

; -------------------------------------------------------------------------------------------
(defn remove-zeros
  [coll]
  (remove zero? coll))
(remove-zeros [1 2 0 4 0 0 7])
; -------------------------------------------------------------------------------------------
(defn merge-left
  ([[first second & rest] newrow]
   (if first
     (if (= first second)
       (recur rest (cons (+ first second) newrow))
       (recur (cons second rest) (cons first newrow)))
     (reverse newrow)))
  ([row]
   (merge-left row '())))
(merge-left [4 4 4 2])
; -------------------------------------------------------------------------------------------
(defn merge-right
  [coll]
  (reverse (merge-left (reverse coll))))
(merge-right [4 4 4 2])
; -------------------------------------------------------------------------------------------
(defn missing-zeroes
  [len row] (repeat (- len (count row)) 0))
(missing-zeroes 4 [2 4])
; -------------------------------------------------------------------------------------------
(defn padd-zeros-left
  [len row]
  (concat row (missing-zeroes len row)))
(padd-zeros-left 6 [2 2 2 4])
; -------------------------------------------------------------------------------------------
(defn padd-zeros-right
  [len row]
  (concat (missing-zeroes len row) row))
(padd-zeros-right 6 [2 2 2 4])
; -------------------------------------------------------------------------------------------
(defn move-left
  [coll]
  (padd-zeros-left
   (count coll)
   (merge-left (remove-zeros coll))))
(move-left [2 2 2 4])
; -------------------------------------------------------------------------------------------
(defn move-right
  [coll]
  (padd-zeros-right
   (count coll)
   (merge-right (remove-zeros coll))))
(move-right [2 2 0 4])
; -------------------------------------------------------------------------------------------
(defn cartesion
  [grid]
  (apply map vector grid))
; -------------------------------------------------------------------------------------------

(defn move-grid-right
  "Moves an entire grid to the right"
  [grid]
  (map move-right grid))

(defn move-grid-left
  "Moves an entire grid to the left"
  [grid]
  (map move-left grid))

(defn move-grid-down
  "Moves an entire grid down"
  [grid]
  (cartesion (map move-right (cartesion grid))))

(defn move-grid-up
  "Moves an entire grid up"
  [grid]
  (cartesion (map move-left (cartesion grid))))
