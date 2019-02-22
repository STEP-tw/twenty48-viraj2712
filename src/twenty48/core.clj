(ns twenty48.core
  (:gen-class))

; -------------------------------------------------------------------------------------------
(defn remove-zeros
  [coll]
  (remove zero? coll))

(defn merge-left
  ([[first second & rest] newrow]
   (if first
     (if (= first second)
       (recur rest (cons (+ first second) newrow))
       (recur (cons second rest) (cons first newrow)))
     (reverse newrow)))
  ([row]
   (merge-left row '())))

(defn merge-right
  [coll]
  (reverse (merge-left (reverse coll))))

(defn missing-zeros
  [len row] (repeat (- len (count row)) 0))

(defn padd-zeros-left
  [len row]
  (concat row (missing-zeros len row)))

(defn padd-zeros-right
  [len row]
  (concat (missing-zeros len row) row))

(defn move-left
  [coll]
  (padd-zeros-left
   (count coll)
   (merge-left (remove-zeros coll))))

(defn move-right
  [coll]
  (padd-zeros-right
   (count coll)
   (merge-right (remove-zeros coll))))

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
