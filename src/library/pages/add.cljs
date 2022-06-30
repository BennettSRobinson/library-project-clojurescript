(ns library.pages.add)


(defn add-book
  []
  [:main.mainAdd
   [:h1.addTitle "Add Book"]
   [:section.addBook
    [:article.addBook__wrapper
     [:form.addBook__forms
      [:label.addBook__forms__wrapper
       [:span.addBook__forms__title "Title"]
       [:input.addBook__forms__input
        {:id "title"
         :type :text
         :placeholder "title"}]]
      [:label.addBook__forms__wrapper
       [:span.addBook__forms__title "Author"]
       [:input.addBook__forms__input--name
        {:id "first"
         :type :text
         :placeholder "First Name...."}]
       [:input.addBook__forms__input--name
        {:id "last"
         :type :text
         :placeholder "Last Name...."}]]
      [:label.addBook__forms__wrapper
       [:span.addBook__forms__title "Summary"]
       [:textarea.addBook__forms__input.addBook__forms__input--synopsis
        {:id "summary"
         :cols 50
         :rows 10
         :placeholder "Input a summary"}]]
      [:div.addBook__forms__wrapper.addBook__forms__wrapper--published
       [:label.addBook__forms__wrapper
        [:span.addBook__forms__title "Published"]
        [:input.addBook__forms__input.addBook__forms__input--calendar
         {:id "published"
          :type :text
          :placeholder "MM/DD/YYYY"}]]
       [:label.addBook__forms__wrapper
        [:span.addBook__forms__title "Pages"]
        [:input.addBook__forms__input.addBook__forms__input--calendar
         {:id "pages"
          :type :number
          :placeholder 0}]]]]]
    [:article.addBook__wrapper.addBook__wrapper--second
     [:div.container
      [:img.container__img {:src "/css/assets/pics/empty.jpeg"}]]]]
   [:div.buttons-Wrapper
    [:button.buttons-Wrapper__btns.buttons-Wrapper__btns--edit "Add Book"]
    [:button.buttons-Wrapper__btns "Cancel"]]])
