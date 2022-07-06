(ns library.pages.details
  (:require [reitit.frontend.easy :as rfe]
            [library.store.state :as state]))

(defn bookDetails
  []
  (let [{:keys [id image title author published pages summary]} @state/current-book]
    ^{:key id}[:main
               [:article.bookPg
                [:section.bookPg__wrapper
                 [:img.bookPg__picture {:src image :alt "image"}]]
                [:section.bookPg__wrapper.bookPg__wrapper--second
                 [:h1.bookPg__details.bookPg__details--title.bookPg__details--desktop title]
                 [:p.bookPg__details.bookPg__details--author author]
                 [:p.bookPg__details.bookPg__details--published "Published: " published]
                 [:p.bookPg__details.bookPg__details--numPgs "Pages: " pages]
                 [:p.bookPg__summary summary]]]
               [:div.buttons-Wrapper
                [:button.buttons-Wrapper__btns.buttons-Wrapper__btns--edit "Edit this Book"]
                [:button.buttons-Wrapper__btns.buttons-Wrapper__btns--delete "Delete this Book"]
                [:button.buttons-Wrapper__btns
                 {:on-click #(rfe/push-state :routes/bookshelf)} "Cancel"]]]))
