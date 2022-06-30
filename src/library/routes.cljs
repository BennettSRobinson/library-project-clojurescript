(ns library.routes
  (:require [reagent.core :as r]
            [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [reitit.coercion.spec :as rss]
            [library.pages.home :refer [home]]
            [library.pages.bookshelf :refer [bookshelf]]
            [library.pages.add :refer [add-book]]))

(defonce routes-state (r/atom #'home))

(def routes
  [["/" {:name :routes/home
         :view #'home}]
   ["/bookshelf" {:name :routes/bookshelf
                  :view #'bookshelf}]
   ["/add" {:name :routes/add
            :view #'add-book}]])
(defn router-start! []
  (rfe/start!
   (rf/router routes {:data {:coercion rss/coercion}})

   (fn [new-match] (reset! routes-state new-match))
   {:use-fragment false}))
