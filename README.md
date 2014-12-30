# cdbview

Personal utility to save couchdb view from file from REPL.

## Usage

[![Clojars Project](http://clojars.org/zenedu/cdbview/latest-version.svg)](http://clojars.org/zenedu/cdbview)

Basically a very simple one, with one namespace and two functions.  

cdbview.core contains create-view and save-view! functions, to be used in combo.  

- create-view works like selmer/render-file, where you supply a filename and a map to replace variables, see selmer for more info. This way you could save a view function in a js file, and use variables so it can be used several times.  
- save-view! to actually save the contain of above file into your couchdb instance, you must supply :host and :dbname in couchmap, and accepts 3 other arguments design-name, view-name, and the map-string generated from create-view.  

Checkout the docstring for more info.  

### Example:

```clojure
(ns yourproject.core
  (:require [cdbview.core :refer :all]))
  
(create-view "view2.js"
             {:type "tPerson"
              :target-key "personName"})
              
(save-view! {:host "http://username:password@localhost:5984/"
             :dbname "party-animals"}
            "personByName"
            "bySubstanceThreshold"
            (create-view "view2.js"
                         {:type "tPerson"
                          :target-key "personName"}))
            
```

## License

Copyright © 2014 PT Zenius Education

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
