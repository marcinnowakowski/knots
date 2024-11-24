(ns simple-knot.oz
    (:require [oz.core :as oz]))

(def knot-data
  {:data {:values [{:x 4 :y 8 :x2 4 :y2 12}
                   {:x 4 :y 8 :x2 12 :y2 8}
                   {:x 4 :y 12 :x2 12 :y2 12}
                   {:x 8 :y 4 :x2 8 :y2 16}
                   {:x 12 :y 8 :x2 16 :y2 8}
                   {:x 12 :y 12 :x2 16 :y2 12}
                   {:x 16 :y 8 :x2 16 :y2 12}
                   {:x 16 :y 12 :x2 20 :y2 12}
                   {:x 16 :y 8 :x2 20 :y2 8}]}
   :mark "line"
   :encoding {:x {:field "x" :type "quantitative"}
              :y {:field "y" :type "quantitative"}
              :x2 {:field "x2"}
              :y2 {:field "y2"}}})

(defn -main []
      (oz/view! knot-data))