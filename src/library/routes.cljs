(ns library.routes
  (:require [reagent.core :as r]
            ;; Reitit Routers
            [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [reitit.coercion.spec :as rss]
            [reitit.frontend.controllers :as rfc]
            ;; Views
            [library.pages.home :refer [home]]
            [library.pages.bookshelf :refer [bookshelf]]
            [library.pages.add :refer [add-book]]
            [library.pages.details :refer [bookDetails]]
            ;;state
            [library.store.actions :as actions]
            [library.store.state :as state]))



(defonce routes-state (r/atom #'home))

(def routes
  [["/" {:name :routes/home
         :view #'home}]
   ["/bookshelf" {:name :routes/bookshelf
                  :view #'bookshelf}]
   ["/add" {:name :routes/add
            :view #'add-book}]
   ["/book/:id" {:name :routes/details
                 :view #'bookDetails
                 :controllers [{:parameters {:path [:id]}
                                :start (fn [parameters]
                                         (actions/getBook (-> parameters :path :id))
                                         (js/console.log @state/current-book))
                                :stop (fn [parameters] (js/console.log "item stop" (-> parameters :path :id)))}]}]])
(defn router-start! []
  (rfe/start!
   (rf/router routes {:data {:coercion rss/coercion}})

   (fn [new-match] (swap! routes-state
                    (fn [old-match]
                      (when new-match
                        (assoc new-match
                          :controllers (rfc/apply-controllers (:controllers old-match) new-match))))))
   {:use-fragment false}))
