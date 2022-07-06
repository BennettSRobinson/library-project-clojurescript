(ns library.store.actions
  (:require [library.store.state :as state]))

(defn getBook
  [id]
  (js/console.log id)
  (let [book (filter #(= (int id) (:id %)) @state/db)]
    (js/console.log book)
    (reset! state/current-book book)))

(defn addBook
  [book]
  (let [newBook (dissoc (assoc book :id (+ (count @state/db) 1)) :preview)]
    (swap! state/db conj newBook)))
