(ns junior.html

(:require [junior.core :refer :all]))

(defn node>
  ([name-]
    (fn this- ([params & body]
      (let [open1 (str "<" name-)
            close1 ">"
            close2 "/>"
            close3 (str "</" name- ">")
            attributes (if (map? params)
                         (reduce-kv #(str (if (= %1 "") " " (str %1 ", ")) %2 "=\"" %3 "\"") "" params)
                         "")]
        (if (and (= (count body) 1) (= (first body) ""))
          (str open1 attributes close2)
          (str open1 attributes close1 (apply str (if (map? params) "" params) body) close3))))
      ([params] (if (map? params) (this- params "") (this- ^:m{} params)))
      ([] (this- "" ""))
      )
    
    )
  )

(def a> (node> "a"))
(def abbr> (node> "abbr"))
(def acronym> (node> "acronym"))
(def address> (node> "address"))
(def applet> (node> "applet"))
(def area> (node> "area"))
(def base> (node> "base"))
(def basefont> (node> "basefont"))
(def big> (node> "big"))
(def blink> (node> "blink"))
(def blockquote> (node> "blockquote"))
(def body> (node> "body"))
(def br> (node> "br"))
(def b> (node> "b"))
(def button> (node> "button"))
(def caption> (node> "caption"))
(def center> (node> "center"))
(def cite> (node> "cite"))
(def code> (node> "code"))
(def col> (node> "col"))
(def dfn> (node> "dfn"))
(def dir> (node> "dir"))
(def div> (node> "div"))
(def dl> (node> "dl"))
(def dt> (node> "dt"))
(def dd> (node> "dd"))
(def em> (node> "em"))
(def font> (node> "font"))
(def form> (node> "form"))
(def h1> (node> "h1"))
(def h2> (node> "h2"))
(def h3> (node> "h3"))
(def h4> (node> "h4"))
(def h5> (node> "h5"))
(def h6> (node> "h6"))
(def head> (node> "head"))
(def hr> (node> "hr"))
(def html> (node> "html"))
(def img > (node> "img "))
(def input> (node> "input"))
(def isindex> (node> "isindex"))
(def i> (node> "i"))
(def kbd> (node> "kbd"))
(def link> (node> "link"))
(def li> (node> "li"))
(def map> (node> "map"))
(def marquee> (node> "marquee"))
(def menu> (node> "menu"))
(def meta> (node> "meta"))
(def ol> (node> "ol"))
(def option> (node> "option"))
(def param> (node> "param"))
(def pre> (node> "pre"))
(def p> (node> "p"))
(def q> (node> "q"))
(def samp> (node> "samp"))
(def script> (node> "script"))
(def select> (node> "select"))
(def small> (node> "small"))
(def span> (node> "span"))
(def strikeout> (node> "strikeout"))
(def strong> (node> "strong"))
(def style> (node> "style"))
(def sub> (node> "sub"))
(def sup> (node> "sup"))
(def table> (node> "table"))
(def td> (node> "td"))
(def textarea> (node> "textarea"))
(def th> (node> "th"))
(def tbody> (node> "tbody"))
(def thead> (node> "thead"))
(def tfoot> (node> "tfoot"))
(def title> (node> "title"))
(def tr> (node> "tr"))
(def tt> (node> "tt"))
(def ul> (node> "ul"))
(def u> (node> "u"))
(def var> (node> "var"))
(defn !doctype> [x] (str "<!DOCTYPE " x ">"))
(defn doc> [& body] (apply str body))
(defn module [v body] ^:x0{:args v :f body})

(defn path-from-ns [ns]
     (clojure.string/join
                  [(clojure.string/replace
                     (clojure.string/replace
                       (str ns) #"\." "/") #"-" "_") ".htmj"]))

(defn resource-path-of-ns [ns]
  (clojure.string/replace-first
    (str (clojure.java.io/resource (path-from-ns ns)))
    "file:"
    "")
  )

(defn 
  ^{:doc "get File .clj corresponding to the symbol ns"}
  htmj-file [ns]
  (let [
        path (path-from-ns ns)
        ]
    (clojure.java.io/as-file (clojure.java.io/resource path))
    )
  )

(defn load-htmj [ns]
  (slurp (resource-path-of-ns ns)))

(jr3 '^:do[^:us[junior.core] [+]])