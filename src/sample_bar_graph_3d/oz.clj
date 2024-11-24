(ns sample-bar-graph-3d.oz
    (:require [oz.core :as oz]))

(def data
  {:data {:values [{:x 1 :y 1 :z 10}
                   {:x 2 :y 1 :z 15}
                   {:x 1 :y 2 :z 20}
                   {:x 2 :y 2 :z 25}]}
   :mark "bar"
   :encoding {:x {:field "x" :type "ordinal"}
              :y {:field "y" :type "ordinal"}
              :z {:field "z" :type "quantitative"}}})

(defn -main []
      ;; Start the Oz server
      (oz/start-server!)

      ;; View the graph
      (oz/view! data))
