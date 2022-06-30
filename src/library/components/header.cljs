(ns library.components.header)

(defn header
  []
  [:header
   [:nav.navBar
    [:h2.navBar__title "The Library"]
    [:ul.navBar__list
     [:li.navBar__list__item
      [:a.navBar__tab.navBar__tab--selector "Home"]]
     [:li.navBar__list__item
      [:a.navBar__tab "Bookshelf"]]
     [:li.navBar__list__item
      [:a.navBar__tab "Add Book"]]]]])
