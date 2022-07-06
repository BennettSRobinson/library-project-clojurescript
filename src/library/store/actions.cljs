(ns library.store.actions
  (:require [library.store.state :as state]))

(defn addBook
  [book]
  (let [newBook (assoc book :id (+ (count @state/db) 1))]
    (swap! state/db conj newBook)))
