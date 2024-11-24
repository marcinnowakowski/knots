(ns simple-knot.ascii
  (:gen-class))

(defn print-knot []
  (println "
                   32222221
                   3      1
         2222222222322222222222221
                   3      1      1
                   3      333333333333333333
                   3             1
                   322222222222221"))

(defn -main [& args]
  (print-knot))
