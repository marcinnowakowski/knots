(ns simple-knot.jfree
  (:gen-class)
  (:import [org.jfree.chart ChartPanel JFreeChart]
           [org.jfree.chart.axis NumberAxis]
           [org.jfree.chart.plot XYPlot]
           [org.jfree.chart.renderer.xy XYBlockRenderer]
           [org.jfree.data.xy DefaultXYZDataset]
           [javax.swing JFrame]
           [org.jfree.chart.renderer LookupPaintScale]
           [java.awt Color]))

(defn create-heatmap []
  ;; Define ASCII data as a grid
  (let [ascii-data [[0 0 0 0 0 0 0 0 0 0]
                    [0 3 2 2 2 2 2 2 2 1]
                    [0 3 0 0 0 0 0 0 0 1]
                    [0 2 2 2 2 2 2 2 2 1]
                    [0 3 0 0 0 1 0 0 0 1]
                    [0 3 0 3 3 3 3 3 3 3]
                    [0 3 0 0 0 0 0 0 0 1]
                    [0 3 2 2 2 2 2 2 2 1]]
        ;; Convert ASCII data to XYZ format
        xyz-data (for [y (range (count ascii-data))
                       x (range (count (first ascii-data)))]
                   [(double x) (double y) (double (get-in ascii-data [y x]))])
        ;; Separate XYZ data into individual arrays
        x-values (double-array (map first xyz-data))
        y-values (double-array (map second xyz-data))
        z-values (double-array (map last xyz-data))
        dataset (DefaultXYZDataset.)]
    ;; Create the 2D array for the dataset
    (let [series-data (into-array (make-array Double/TYPE 3 (count x-values)))]
      (aset series-data 0 x-values)
      (aset series-data 1 y-values)
      (aset series-data 2 z-values)
      (.addSeries dataset "Heatmap" series-data))

    ;; Create a paint scale
    (let [paint-scale (LookupPaintScale. 0.0 3.0 Color/WHITE)
          _ (doseq [[value color] [[1 Color/GREEN]
                                   [2 Color/YELLOW]
                                   [3 Color/RED]]]
              (.add paint-scale value color))
          renderer (doto (XYBlockRenderer.)
                     (.setPaintScale paint-scale))
          x-axis (NumberAxis. "X")
          y-axis (NumberAxis. "Y")
          plot (doto (XYPlot. dataset x-axis y-axis renderer)
                 (.setDomainPannable true)
                 (.setRangePannable true))
          chart (doto (JFreeChart. "Heatmap Example"
                                   JFreeChart/DEFAULT_TITLE_FONT
                                   plot true)
                  (.removeLegend))]

      ;; Display the chart in a JFrame
      (doto (JFrame. "Heatmap Example")
        (.setContentPane (ChartPanel. chart))
        (.setSize 800 600)
        (.setVisible true)))))

;; Main function
(defn -main [& args]
  (create-heatmap))
