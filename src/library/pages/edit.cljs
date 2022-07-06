(ns library.pages.edit
  (:require [reitit.frontend.easy :as rfe]
            [reagent.core :as r]
            [library.store.actions :as actions]
            [library.store.state :as state]))


(defn editBook! [event id localState]
  (.preventDefault event)
  (actions/editBook id localState)
  (rfe/push-state :routes/bookshelf))

(defn editImage! [event state]
  (let [^js/File file (-> event .-target .-files (aget 0))]
    (swap! state assoc :preview (.. js/window -URL (createObjectURL file)))
    (swap! state assoc :image (:preview @state))
    (set! (-> event .-target .-value) "")))

(defn edit-book
  []
  (let [{:keys [id title image author published pages summary]} @state/current-book
        empty "/css/assets/pics/empty.jpeg"
        initial-state {:id id
                       :title title
                       :author author
                       :summary summary
                       :published published
                       :pages pages
                       :preview image
                       :image image}
        state (r/atom initial-state)]
    (fn []
      [:main.mainAdd
       [:h1.addTitle "Edit Book"]
       [:section.addBook
        [:article.addBook__wrapper
         [:form.addBook__forms
          [:label.addBook__forms__wrapper
           [:span.addBook__forms__title "Title"]
           [:input.addBook__forms__input
            {:id "title"
             :type :text
             :on-change #(swap! state assoc :title (.. % -target -value))
             :value (:title @state)
             :placeholder "title"}]]
          [:label.addBook__forms__wrapper
           [:span.addBook__forms__title "Author"]
           [:input.addBook__forms__input
            {:id "author"
             :type :text
             :on-change #(swap! state assoc :author (.. % -target -value))
             :value (:author @state)
             :placeholder "Author...."}]]
          [:label.addBook__forms__wrapper
           [:span.addBook__forms__title "Summary"]
           [:textarea.addBook__forms__input.addBook__forms__input--synopsis
            {:id "summary"
             :cols 50
             :rows 10
             :value (:summary @state)
             :on-change #(swap! state assoc :summary (.. % -target -value))
             :placeholder "Input a summary"}]]
          [:div.addBook__forms__wrapper.addBook__forms__wrapper--published
           [:label.addBook__forms__wrapper
            [:span.addBook__forms__title "Published"]
            [:input.addBook__forms__input.addBook__forms__input--calendar
             {:id "published"
              :type :text
              :value (:published @state)
              :on-change #(swap! state assoc :published (.. % -target -value))
              :placeholder "MM/DD/YYYY"}]]
           [:label.addBook__forms__wrapper
            [:span.addBook__forms__title "Pages"]
            [:input.addBook__forms__input.addBook__forms__input--calendar
             {:id "pages"
              :type :number
              :on-change #(swap! state assoc :pages (.. % -target -value))
              :value (:pages @state)
              :placeholder 0}]]]]]
        [:article.addBook__wrapper.addBook__wrapper--second
         [:div.container
          [:img.container__img {:src (if (empty? (:preview @state))
                                       empty
                                       (:preview @state))}]]
         [:div.container__button
          [:button
           {:on-click #(.click (js/document.getElementById "getFile"))} "Add Image"]
          [:input
           {:id "getFile"
            :type :file
            :style {:visibility "hidden"}
            :on-change #(editImage! % state)}]]]]
       [:div.buttons-Wrapper
        [:button.buttons-Wrapper__btns.buttons-Wrapper__btns--edit {:type :submit
                                                                    :on-click #(editBook! % id @state) } "Edit Book"]
        [:button.buttons-Wrapper__btns {:on-click #(rfe/push-state :routes/bookshelf)}"Cancel"]]])))
