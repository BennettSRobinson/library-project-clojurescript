(ns library.state
  (:require [reagent.core :as r]))

(def db (r/atom {
                 :book-1 {
                           :id :book-1
                           :author "H.P Lovecraft"
                           :title "Call of Cthulhu"
                           :summary "'The Call of Cthulhu' is a short story by
           American horror writer H. P. Lovecraft, written in August and September 1926 and
           originally serialized in the February 1928 issue of Weird Tales. It is the only
           story written by Lovecraft in which the extraterrestrial entity Cthulhu himself
           makes a major appearance. The story is written in a documentary style, with
           three independent narratives linked together by the device of a narrator
           discovering notes left by a deceased relative."
                           :picture "css/assets/pics/CallOfCthulhu.jpg"
                           :published "November 1919"
                           :pages 4
                           :rating 4}
                 :book-2 {

                           :id :book-2
                           :author "Keith Davidson"
                           :title "Dagon"
                           :summary "'Dagon is a deity who presides over the
Deep Ones, an amphibious humanoid race that currently resides in the Earth's
oceans. He is first introduced in Lovecraft's short story 'Dagon;', and is
mentioned extensively throughout the mythos. Also known as Father Dagon and the
consort of Mother Hydra, although they are Deities, they are generally not
considered Great Old Ones."
                          :picture ""
                          :published "07/02/1919"
                          :pages 4
                          :rating 5}}))
