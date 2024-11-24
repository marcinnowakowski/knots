(ns sample-contour-plot.oz
  (:require [oz.core :as oz]))

(def data
  {:data {:values (for [x (range -10 11)
                        y (range -10 11)]
                    {:x x :y y :z (+ (* x x) (* y y))})}
   :mark "contour"
   :encoding {:x {:field "x" :type "quantitative"}
              :y {:field "y" :type "quantitative"}
              :color {:field "z" :type "quantitative"}}})

(defn -main []
  ;; Start the Oz server
  (oz/start-server!)

  ;; View the contour plot
  (oz/view! data))
