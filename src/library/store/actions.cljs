(ns library.store.actions
  (:require [library.store.state :as state]))

(defn addBook
  [book]
  (let [newBook (dissoc (assoc book :id (+ (count @state/db) 1)) :preview)]
    (swap! state/db conj newBook)))
