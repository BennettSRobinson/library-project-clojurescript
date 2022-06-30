(ns library.components.header
  (:require [reitit.frontend.easy :as rfe]))

(defn header
  []
  [:header
   [:nav.navBar
    [:h2.navBar__title "The Library"]
    [:ul.navBar__list
     [:li.navBar__list__item
      [:a.navBar__tab.navBar__tab--selector {:href (rfe/href :routes/home)}"Home"]]
     [:li.navBar__list__item
      [:a.navBar__tab {:href (rfe/href :routes/bookshelf)} "Bookshelf"]]
     [:li.navBar__list__item
      [:a.navBar__tab {:href (rfe/href :routes/add)} "Add Book"]]]]])
