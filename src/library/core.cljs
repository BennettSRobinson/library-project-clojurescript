(ns library.core
  (:require [reagent.core :as r]
            [library.components.header :refer [header]]
            [library.pages.home :refer [home]]
            [library.components.footer :refer [footer]]
            [library.errBoundary :refer [err-boundary]]))

(defn app
  []
  [:div
   [header]
   [home]
   [footer]])


(defn ^:export main
  []
  (r/render
    [err-boundary
     [app]]
    (.getElementById js/document "app")))
