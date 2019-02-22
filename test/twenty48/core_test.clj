(ns twenty48.core-test
  (:require [clojure.test :refer :all]
            [twenty48.core :refer :all]))

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