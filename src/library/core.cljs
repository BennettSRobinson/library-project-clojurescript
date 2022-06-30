(ns library.core
  (:require [reagent.core :as r]
            [library.routes :refer [routes-state router-start!]]
            [library.components.header :refer [header]]
            [library.components.footer :refer [footer]]
            [library.errBoundary :refer [err-boundary]]))

(defn app
  []
  [:div
   [header]
   (let [current-view (-> @routes-state :data :view)]
     [current-view])
   [footer]])


(defn ^:export main
  []
  (router-start!)
  (r/render
    [err-boundary
     [app]]
    (.getElementById js/document "app")))
