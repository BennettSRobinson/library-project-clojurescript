(ns library.pages.bookshelf
  (:require [library.store.state :as state]))

(defn bookshelf
  []
  [:main
   [:article
    [:h1.title "Ph'nglui mglw'nafh Cthulhu R'lyeh wgah'nagl fhtagn"]]
   [:section.main
    (for [{:keys [id author title picture]} (vals @state/db)]
      [:a.book {:key id}
       [:div.book__picture__container
        [:img.book__picture {:src picture :alt title}]]
       [:p.book__details title]
       [:p.book_details author]])]])
