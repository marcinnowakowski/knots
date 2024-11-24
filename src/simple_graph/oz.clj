(ns simple-graph.oz
    (:require [oz.core :as oz]))

(def data
  {:data {:values [{:category "A" :value 10}
                   {:category "B" :value 20}
                   {:category "C" :value 30}]}
   :mark "bar"
   :encoding {:x {:field "category" :type "nominal"}
              :y {:field "value" :type "quantitative"}}})

(defn -main []
      ;; Start the Oz server (required for visualization)
      (oz/start-server!)

      ;; View the graph
      (oz/view! data))