(ns simple-graph.jfree
  (:import [org.jfree.chart ChartFactory ChartPanel]
           [org.jfree.chart.plot PlotOrientation]
           [org.jfree.data.category DefaultCategoryDataset]
           [javax.swing JFrame]))

(defn create-bar-chart []
  (let [dataset (DefaultCategoryDataset.)]
    (.addValue dataset 5 "Category 1" "Label A")
    (.addValue dataset 3 "Category 2" "Label B")
    (.addValue dataset 8 "Category 3" "Label C")
    (ChartFactory/createBarChart
      "Sample Bar Chart"
      "Category"
      "Value"
      dataset
      PlotOrientation/VERTICAL
      true true false)))

(defn display-chart [chart]
  (let [frame (JFrame. "Chart Example")
        panel (ChartPanel. chart)]
    (.setContentPane frame panel)
    (.setSize frame 800 600)
    (.setDefaultCloseOperation frame JFrame/EXIT_ON_CLOSE)
    (.setVisible frame true)))

(defn -main []
  (let [chart (create-bar-chart)]
    (display-chart chart)))
