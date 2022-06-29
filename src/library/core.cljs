(ns library.core
  (:require [reagent.core :as r]))

(defn app
  []
  [:p "Hello World"])

(defn ^:export main
  []
  (r/render
    [app]
    (.getElementById js/document "app")))
