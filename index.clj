{:namespaces
 ({:source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motificmotific.anagram-api.html",
   :name "motific.anagram",
   :doc nil}
  {:source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motificmotific.core-api.html",
   :name "motific.core",
   :doc nil}
  {:source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motificmotific.output-api.html",
   :name "motific.output",
   :doc nil}
  {:source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motificmotific.util-api.html",
   :name "motific.util",
   :doc nil}
  {:source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motificmotific.word-list-api.html",
   :name "motific.word-list",
   :doc nil}),
 :vars
 ({:arglists ([letter words]),
   :name "add-letter-to-each-word",
   :namespace "motific.anagram",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.anagram-api.html#motific.anagram/add-letter-to-each-word",
   :doc
   "Step 1 permutation, accepts a collection of words as vectors and adds a letter to each",
   :var-type "function",
   :line 29,
   :file "src/motific/anagram.clj"}
  {:arglists ([letter word]),
   :name "add-letter-to-word",
   :namespace "motific.anagram",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.anagram-api.html#motific.anagram/add-letter-to-word",
   :doc
   "Step 2 permutation, accepts a word-vector and adds a letter at every position",
   :var-type "function",
   :line 23,
   :file "src/motific/anagram.clj"}
  {:arglists ([words w]),
   :name "find-in-list",
   :namespace "motific.anagram",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.anagram-api.html#motific.anagram/find-in-list",
   :doc
   "Given list 'words', checks to see possible anagrams for word 'w'",
   :var-type "function",
   :line 69,
   :file "src/motific/anagram.clj"}
  {:arglists ([w]),
   :name "get-valid",
   :namespace "motific.anagram",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.anagram-api.html#motific.anagram/get-valid",
   :doc "Just a wrapper around permutate to sort / distinct",
   :var-type "function",
   :line 59,
   :file "src/motific/anagram.clj"}
  {:arglists ([w words]),
   :name "get-valid-in-list",
   :namespace "motific.anagram",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.anagram-api.html#motific.anagram/get-valid-in-list",
   :doc
   "Supply a word to generate anagrams for followed by a list of valid words",
   :var-type "function",
   :line 64,
   :file "src/motific/anagram.clj"}
  {:arglists ([first-word] [first-word & other-words]),
   :name "has-anagrams?",
   :namespace "motific.anagram",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.anagram-api.html#motific.anagram/has-anagrams?",
   :doc
   "If passed one word, returns an anonymous function for use as\na comparator, else compares the words and returns a boolean",
   :var-type "function",
   :line 49,
   :file "src/motific/anagram.clj"}
  {:arglists ([letter word pos]),
   :name "insert-letter",
   :namespace "motific.anagram",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.anagram-api.html#motific.anagram/insert-letter",
   :doc
   "Step 3 permutation: inserts a letter into word-vector given position 'pos'.",
   :var-type "function",
   :line 18,
   :file "src/motific/anagram.clj"}
  {:arglists ([w & {:keys [fixed-length], :or {fixed-length false}}]),
   :name "permutate",
   :namespace "motific.anagram",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.anagram-api.html#motific.anagram/permutate",
   :doc
   "Generates all possible permutations of a word.\nSpecify :fixed-length true to only return permutations\nthat are the same length.",
   :var-type "function",
   :line 34,
   :file "src/motific/anagram.clj"}
  {:file "src/motific/core.clj",
   :raw-source-url nil,
   :source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.core-api.html#motific.core/actions",
   :namespace "motific.core",
   :line 33,
   :var-type "var",
   :doc
   "Hash to store action-to-fn mappings. Help returns nil as a default so output/process will just display the banner",
   :name "actions"}
  {:arglists ([settings]),
   :name "get-anagram",
   :namespace "motific.core",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.core-api.html#motific.core/get-anagram",
   :doc "fn to fetch anagrams",
   :var-type "function",
   :line 9,
   :file "src/motific/core.clj"}
  {:arglists ([settings]),
   :name "get-permutate",
   :namespace "motific.core",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.core-api.html#motific.core/get-permutate",
   :doc "fn that returns a map of all permutations of supplied words.",
   :var-type "function",
   :line 16,
   :file "src/motific/core.clj"}
  {:arglists ([settings]),
   :name "get-random",
   :namespace "motific.core",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.core-api.html#motific.core/get-random",
   :doc "fn for 'random' action",
   :var-type "function",
   :line 21,
   :file "src/motific/core.clj"}
  {:arglists ([action]),
   :name "unknown-action",
   :namespace "motific.core",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.core-api.html#motific.core/unknown-action",
   :doc "Display a helpful message if passed an unknown action.",
   :var-type "function",
   :line 28,
   :file "src/motific/core.clj"}
  {:arglists ([settings]),
   :name "process",
   :namespace "motific.output",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.output-api.html#motific.output/process",
   :doc
   "Process the :data from the settings map provided by motific.core/-main",
   :var-type "function",
   :line 57,
   :file "src/motific/output.clj"}
  {:arglists ([fmt]),
   :name "select",
   :namespace "motific.output",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.output-api.html#motific.output/select",
   :doc
   "motific.core/parse-cli's :parse-fn to select --output format.",
   :var-type "function",
   :line 9,
   :file "src/motific/output.clj"}
  {:arglists ([path]),
   :name "file-exists",
   :namespace "motific.util",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.util-api.html#motific.util/file-exists",
   :doc
   "Pred function for use with some,\nreturns the path if exists and isFile",
   :var-type "function",
   :line 9,
   :file "src/motific/util.clj"}
  {:arglists ([coll & items]),
   :name "in?",
   :namespace "motific.util",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.util-api.html#motific.util/in?",
   :doc "Check to see if a collection contains an item",
   :var-type "function",
   :line 24,
   :file "src/motific/util.clj"}
  {:arglists ([f args]),
   :name "pass-args",
   :namespace "motific.util",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.util-api.html#motific.util/pass-args",
   :doc
   "Allows one to pass a hash to a variadic function that expects keyword args",
   :var-type "function",
   :line 19,
   :file "src/motific/util.clj"}
  {:arglists ([wordlist]),
   :name "filter-valid",
   :namespace "motific.word-list",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.word-list-api.html#motific.word-list/filter-valid",
   :doc
   "Take a sequence of words and lowercases, sorts,\nremoves duplicates, and filters the sequence\nbased on word length and whether the word is\nonly #\"[a-z]\".",
   :var-type "function",
   :line 33,
   :file "src/motific/word_list.clj"}
  {:arglists ([]),
   :name "find-installed",
   :namespace "motific.word-list",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.word-list-api.html#motific.word-list/find-installed",
   :doc "Searches standard unix paths for installed words file.",
   :var-type "function",
   :line 21,
   :file "src/motific/word_list.clj"}
  {:arglists ([] [file] [file params]),
   :name "generate",
   :namespace "motific.word-list",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.word-list-api.html#motific.word-list/generate",
   :doc "Generate a word-list collection from 'file'",
   :var-type "function",
   :line 46,
   :file "src/motific/word_list.clj"}
  {:arglists
   ([words
     &
     {:keys [min-length max-length exact-length quantity],
      :or default-params,
      :as args}]),
   :name "random",
   :namespace "motific.word-list",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.word-list-api.html#motific.word-list/random",
   :doc
   "Returns a randomized sequence of words from a collection with optional parameters:\n[min-length max-length exact-length quantity]\nPass 'nil' to the quantity parameter to get the lazy sequence instead of a set quantity.",
   :var-type "function",
   :line 60,
   :file "src/motific/word_list.clj"}
  {:arglists
   ([&
     {:keys [min-length max-length exact-length quantity],
      :or default-params}]),
   :name "valid-word-length?",
   :namespace "motific.word-list",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "http://scryptmouse.github.com/motific/motific.word-list-api.html#motific.word-list/valid-word-length?",
   :doc
   "Returns a comparator function that checks the length of a word based on specific parameters",
   :var-type "function",
   :line 26,
   :file "src/motific/word_list.clj"})}
