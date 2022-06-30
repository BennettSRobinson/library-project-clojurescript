(ns library.pages.home)

(defn home
  []
  [:div
   [:section.homepage
    [:p.homepage__title "Books."
     [:span.homepage__info "Read the books if you dare."]]]
   [:section.mainHome
    [:p.mainHome__title "Welcome to the library"]
    [:p.mainHome__description "This is the greatest book in the world you should
definiety come pick it up."]
    [:button.btn "See Books"]
    [:p.mainHome__description "This is a very long text that you should look at
if you want to know what is going on. This project wants me to write some text
about some books"]
    [:button.btn "Add a book"]]])
