(ns junior.debug
  (:require [junior.core])
  )

(defn path-from-ns [ns]
     (clojure.string/join
                  [(clojure.string/replace
                     (clojure.string/replace
                       (str ns) #"\." "/") #"-" "_") ".clj"]))

(defn resource-path-of-ns [ns]
  (clojure.string/replace-first
    (str (clojure.java.io/resource (path-from-ns ns)))
    "file:"
    "")
  )

(defn 
  ^{:doc "get File .clj corresponding to the symbol ns"}
  clj-file [ns]
  (let [
        path (path-from-ns ns)
        ]
    (clojure.java.io/as-file (clojure.java.io/resource path))
    )
  )

(defn load-clj [ns]
  (slurp (resource-path-of-ns ns)))

(defn read-clj [ns]
  (read-string (load-clj ns)))

