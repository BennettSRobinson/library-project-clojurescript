(ns library.core
  (:require [reagent.core :as r]
            [library.pages.home :refer [home]]
            [library.errBoundary :refer [err-boundary]]))

(defn app
  []
  [home])

(defn ^:export main
  []
  (r/render
    [err-boundary
     [app]]
    (.getElementById js/document "app")))
