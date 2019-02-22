(ns twenty48.core-test
  (:require [clojure.test :refer :all]
            [twenty48.core :refer :all]))

(deftest removing-zeros
  (testing "row for removing zeros"
    (is (= '(2) (remove-zeros '(0 0 0 2))))
    (is (= '(4) (remove-zeros '(0 0 0 4))))
    (is (= '(2 4) (remove-zeros '(0 2 0 4))))
    (is (= '(2 4 2 4) (remove-zeros '(2 4 2 4))))))

(deftest finding-missing-zeros
  (testing "original row length and new row for counting missing zeros"
    (is (= '(0 0 0) (missing-zeros 4 '(2))))
    (is (= '(0 0) (missing-zeros 4 '(2 4))))
    (is (= '(0) (missing-zeros 4 '(2 4 2))))
    (is (= '() (missing-zeros 4 '(2 4 2 4))))))

(deftest padding-zeros-right
  (testing "original row length and new row for padding zeros right"
    (is (= '(0 0 0 2) (padd-zeros-right 4 '(2))))
    (is (= '(0 0 2 4) (padd-zeros-right 4 '(2 4))))
    (is (= '(0 2 4 2) (padd-zeros-right 4 '(2 4 2))))
    (is (= '(2 4 2 4) (padd-zeros-right 4 '(2 4 2 4))))))

(deftest padding-zeros-left
  (testing "original row length and new row for padding zeros left"
    (is (= '(2 0 0 0) (padd-zeros-left 4 '(2))))
    (is (= '(2 4 0 0) (padd-zeros-left 4 '(2 4))))
    (is (= '(2 4 2 0) (padd-zeros-left 4 '(2 4 2))))
    (is (= '(2 4 2 4) (padd-zeros-left 4 '(2 4 2 4))))))

(deftest merging-row-right
  (testing "row for merging right"
    (is (= '(4) (merge-right '(2 2))))
    (is (= '(4 4) (merge-right '(2 2 4))))
    (is (= '(4) (merge-right '(2 2))))
    (is (= '(4) (merge-right '(2 2))))
    (is (= '(4) (merge-right '(2 2))))
    (is (= '(2 4) (merge-right '(2 2 2))))
    (is (= '(4 4) (merge-right '(2 2 2 2))))
    (is (= '(2 4) (merge-right '(2 2 2))))))

(deftest merging-row-left
  (testing "row for merging left"
    (is (= '(4) (merge-left '(2 2))))
    (is (= '(4 4) (merge-left '(2 2 4))))
    (is (= '(4) (merge-left '(2 2))))
    (is (= '(4) (merge-left '(2 2))))
    (is (= '(4) (merge-left '(2 2))))
    (is (= '(4 2) (merge-left '(2 2 2))))
    (is (= '(4 4) (merge-left '(2 2 2 2))))
    (is (= '(4 2) (merge-left '(2 2 2))))))

(deftest moving-row-right
  (testing "row for moving right "
    (is (= '(0 0 0 4) (move-right '(2 0 0 2))))
    (is (= '(0 0 4 4) (move-right '(2 0 2 4))))
    (is (= '(0 0 0 4) (move-right '(2 0 2 0))))
    (is (= '(0 0 0 4) (move-right '(0 0 2 2))))
    (is (= '(0 0 0 4) (move-right '(0 2 2 0))))
    (is (= '(0 0 2 4) (move-right '(0 2 2 2))))
    (is (= '(0 0 4 4) (move-right '(2 2 2 2))))
    (is (= '(0 0 2 4) (move-right '(0 2 2 2))))))

(deftest moving-row-left
  (testing "row for moving left "
    (is (= '(4 0 0 0) (move-left '(2 0 0 2))))
    (is (= '(4 4 0 0) (move-left '(2 0 2 4))))
    (is (= '(4 0 0 0) (move-left '(2 0 2 0))))
    (is (= '(4 0 0 0) (move-left '(0 0 2 2))))
    (is (= '(4 0 0 0) (move-left '(0 2 2 0))))
    (is (= '(4 2 0 0) (move-left '(0 2 2 2))))
    (is (= '(4 4 0 0) (move-left '(2 2 2 2))))
    (is (= '(4 2 0 0) (move-left '(0 2 2 2))))))

(deftest grid-cartesion
  (testing "rows with numbers that repeat"
    (is (= '((0 0 2 0)
             (0 2 0 4)
             (2 0 2 4)
             (2 4 0 0))
           (cartesion
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0))))))
  (testing "rows with numbers that repeat"
    (is (= '((0 2 4 2)
             (4 2 2 4)
             (2 4 4 0)
             (4 4 4 0))
           (cartesion
            '((0 4 2 4)
              (2 2 4 4)
              (4 2 4 4)
              (2 4 0 0))))))
  (testing "rows with numbers that repeat"
    (is (= '((2 2 2 2)
             (4 2 0 4)
             (2 4 2 2)
             (4 2 4 2))
           (cartesion
            '((2 4 2 4)
              (2 2 4 2)
              (2 0 2 4)
              (2 4 2 2))))))
  (testing "rows with numbers that repeat"
    (is (= '((2 2 2 2)
             (4 4 4 4)
             (4 2 2 2)
             (4 4 4 2))
           (cartesion
            '((2 4 4 4)
              (2 4 2 4)
              (2 4 2 4)
              (2 4 2 2)))))))

(deftest moving-grid-right
  (testing "rows with numbers that repeat"
    (is (= '((0 0 0 4)
             (0 0 2 4)
             (0 0 0 4)
             (0 0 0 8))
           (move-grid-right
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0))))))
  (testing "rows with numbers that repeat"
    (is (= '((0 0 2 4)
             (0 4 2 4)
             (0 2 4 2)
             (0 0 4 8))
           (move-grid-right
            '((0 2 2 2)
              (4 2 0 4)
              (2 4 2 0)
              (4 4 4 0))))))
  (testing "rows with numbers that repeat"
    (is (= '((0 0 4 4)
             (0 4 2 4)
             (0 2 4 4)
             (4 2 4 2))
           (move-grid-right
            '((2 2 2 2)
              (4 2 0 4)
              (2 4 2 2)
              (4 2 4 2))))))
  (testing "rows with numbers that repeat"
    (is (= '((0 0 4 4)
             (0 0 8 8)
             (0 4 2 4)
             (0 4 8 2))
           (move-grid-right
            '((2 2 2 2)
              (4 4 4 4)
              (4 2 2 2)
              (4 4 4 2)))))))

(deftest moving-grid-left
  (testing "rows with numbers that repeat"
    (is (= '((4 0 0 0)
             (2 4 0 0)
             (4 0 0 0)
             (8 0 0 0))
           (move-grid-left
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0))))))
  (testing "rows with numbers that repeat"
    (is (= '((4 2 0 0)
             (4 2 4 0)
             (2 4 2 0)
             (8 4 0 0))
           (move-grid-left
            '((0 2 2 2)
              (4 2 0 4)
              (2 4 2 0)
              (4 4 4 0))))))
  (testing "rows with numbers that repeat"
    (is (= '((4 4 0 0)
             (4 2 4 0)
             (4 4 2 0)
             (4 2 4 2))
           (move-grid-left
            '((2 2 2 2)
              (4 2 0 4)
              (2 2 4 2)
              (4 2 4 2))))))
  (testing "rows with numbers that repeat"
    (is (= '((4 4 0 0)
             (8 8 0 0)
             (4 4 2 0)
             (8 4 2 0))
           (move-grid-left
            '((2 2 2 2)
              (4 4 4 4)
              (4 2 2 2)
              (4 4 4 2)))))))

(deftest moving-grid-up
  (testing "rows with numbers that repeat"
    (is (= '((2 2 4 2)
             (0 4 4 4)
             (0 0 0 0)
             (0 0 0 0))
           (move-grid-up
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0))))))
  (testing "rows with numbers that repeat"
    (is (= '((2 4 2 8)
             (4 4 8 4)
             (2 4 0 0)
             (0 0 0 0))
           (move-grid-up
            '((0 4 2 4)
              (2 2 4 4)
              (4 2 4 4)
              (2 4 0 0))))))
  (testing "rows with numbers that repeat"
    (is (= '((4 4 2 4)
             (4 2 4 2)
             (0 4 4 4)
             (0 0 0 2))
           (move-grid-up
            '((2 4 2 4)
              (2 2 4 2)
              (2 0 2 4)
              (2 4 2 2))))))
  (testing "rows with numbers that repeat"
    (is (= '((4 8 4 8)
             (4 8 4 4)
             (0 0 2 2)
             (0 0 0 0))
           (move-grid-up
            '((2 4 4 4)
              (2 4 2 4)
              (2 4 2 4)
              (2 4 2 2)))))))

(deftest moving-grid-down
  (testing "rows with numbers that repeat"
    (is (= '((0 0 0 0)
             (0 0 0 0)
             (0 2 4 2)
             (2 4 4 4))
           (move-grid-down
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0))))))
  (testing "rows with numbers that repeat"
    (is (= '((0 0 0 0)
             (2 4 0 0)
             (4 4 2 4)
             (2 4 8 8))
           (move-grid-down
            '((0 4 2 4)
              (2 2 4 4)
              (4 2 4 4)
              (2 4 0 0))))))
  (testing "rows with numbers that repeat"
    (is (= '((0 0 0 4)
             (0 4 2 2)
             (4 2 4 4)
             (4 4 4 2))
           (move-grid-down
            '((2 4 2 4)
              (2 2 4 2)
              (2 0 2 4)
              (2 4 2 2))))))
  (testing "rows with numbers that repeat"
    (is (= '((0 0 0 0)
             (0 0 4 4)
             (4 8 2 8)
             (4 8 4 2))
           (move-grid-down
            '((2 4 4 4)
              (2 4 2 4)
              (2 4 2 4)
              (2 4 2 2)))))))