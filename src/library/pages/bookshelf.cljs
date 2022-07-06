(ns library.pages.bookshelf
  (:require [library.store.state :as state]
            [reitit.frontend.easy :as rfe]))

(defn bookshelf
  []
  [:main
   [:article
    [:h1.title "Ph'nglui mglw'nafh Cthulhu R'lyeh wgah'nagl fhtagn"]]
   [:section.main
    (for [{:keys [id author title image]} @state/db]
      ^{:key id}[:a.book {:on-click #(rfe/push-state :routes/details {:id id})}
                 [:div.book__picture__container
                  [:img.book__picture {:src image :alt title}]]
                 [:p.book__details title]
                 [:p.book_details author]])]])
