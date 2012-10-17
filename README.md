# motific

A collection of functions for manipulating a `words` file.

Written mostly as an exercise in learning Clojure.

## Usage

It can be run with leiningen, compiled into a jar, or included as a dependency.

### leiningen / jar

```
lein run anagram [word1, word2…]
lein run permutate [word1, word2…]
lein run random
```

Basic options:

* _-f / --from_ to specify a (newline-separated) list of words to use. Defaults to system (/usr/share/dict/words, /usr/dict/words, `$PWD`/words)
* _-o / --output [format]_ to specify output format. Defaults to 'text'. Formats are:
    * **text** Easy piping to grep, awk, etc.
    * **clj** Returns the stringified clojure representation of the data (debugging)
    * **json**
    * **xml**
    * **yaml**

Random supports the the following options:

* _-q / --quantity_
* _-m / --min-length_ minimum length of words
* _-M / --max-length_ maximum length of words
* _-e / --exact-length_ Exact length of words

## License

Copyright (C) 2012 [Alexandra Grey](http://alexa.is "alexa.is")

Distributed under the Eclipse Public License, the same as Clojure.
