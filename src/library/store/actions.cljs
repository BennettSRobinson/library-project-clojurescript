(ns library.store.actions
  (:require [library.store.state :as state]))


(defn getBook
  [id]
  (let [book (first (filter #(= (int id) (:id %)) @state/db))]
    (reset! state/current-book book)))

(defn editBook
  [id newBook]
  (let [book (dissoc newBook :preview)
        index (.indexOf @state/db (first (filter #(= (int id) (:id %)) @state/db)))]
    (swap! state/db assoc-in [index] book)))

(defn deleteBook
  [id]
  (reset! state/db (remove #(= (int id) (:id %)) @state/db)))

(defn addBook
  [book]
  (let [newBook (dissoc (assoc book :id (+ (count @state/db) 1)) :preview)]
    (swap! state/db conj newBook)))
