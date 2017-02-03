1. multiple-arity
2. forms

http://www.cs.cornell.edu/courses/cs312/2003sp/handouts/emacs.htm

Emacs
* Open file: C-x C-f
* Copy (kill-ring-save): M-w
* Paste (yank): C-y
* Cut (kill): C-w 
* Stop process: C-G
* New buffer: C-x + b
* Kill buffer: C-x + k
* Concurrency:
    * Reference cells:
    * Mutual exclusion:
    * Deadlock:
    * Reference Types to manage state:
        * atom: allow you to work with state, update an identity
        * ref:
        * watch: watches for a state change
        * var:

* Macros: Look like a function, always return a list. Function arguments are fully evaluated before being passed to the function, but Marco arguments are passed in unevaluated. (1 + 1). Need to be careful about symbols and values. Use a single leading quote to turn off the evaluation for whatever follows, like 'let. The single leading quote is actually a macro for (quote)
    * Reader macro: Sets of rules for transforming text into data structures. They're designated by macro characters like ' (the single quote), # and @. The most used on is ;
    * Macro: Take arguments and return a value like a function. But they are executed after the reader and before the evaluator. When you call a macro, the individual elements of a data structure are not called. The entire data structure is. While a data structure returned by a function is not evaluated, a data structure returned by a macro is evaluated. You can take (1 + 2) and have it actually evaluate correctly with (+ 1 2).
            * Understand the difference between normal single quotes, syntax quoting and using a tilde to kill internally a syntax quote's power.
            * Unquote splicing: ~@ is like a sledgehammer to a data structure piñata.
        * Gotchas:
            * Variable capture: When a macro introduces a binding that ecplises an existing binding.
            * Double Evaluation: When a form passed to a macro (as an argument) gets evaluated more than once.
* Modes: A collection of key binds and functions packaged together to help you be productive when editing different types of files. You can install packages of modes, which are searchable like addons in Sublime.
    * Major: Markdown and Clojure. They're set by Emacs when you open a file. Only one major is active at a time.
    * Minor: Useful across file types. Multiple can run at any time.
* REPL: Allows you to execute your code like watching console log.
    * To start a REPL: 
        * Open a clojure file in the left window
        * M-x cider-jack-in
            * x must be lowercase
* namespace: 
    * (use 'my-stuff.core :reload) to recompile the Clojure code into Java

Data Structures
* Vector: Linear data structure. In general, vectors offer faster lookup than a list. because get (which can't be run on lists) is faster. Use vectors by default instead of a list except when you need to add something to the beginning of a sequence.
    * [1 2 3]
* List: Similar, but starts with a ' and can't be looked up with get. Instead, you look up with the nth function. Use a list when you need add something to the beginning of a sequence or you're writing a macro. (sequence: logical list that can be sequentially traversed.)
    * '(1 2 3 4)
    * use the nth function to retrieve an item from the list (nth '(1 2 3 4) 0)
* Sets: Collections of unique values that are not preserved in order. there are two types in Clojure.
    * hash set: Used more often and appears to be just a key/value pair like an object in Javascript.
        * http://stackoverflow.com/questions/14657178/clojure-list-vs-vector-vs-set
    * sorted set: 
* Maps: The keyword is (:first-name) is just a function so you can call it.
    * {:first-name "Tad" :last-name "Whitaker}
* Numbers: 
* Strings:

Functions:
* Collection abstraction: If the sequence abstraction operates on individual elements of a sequence, the collection abstraction is about the data structure as a whole. Examples are count, empty? and every?.
* defn: A named function
* defn-: A private function that can't be accessed from a different namespace.
* Destructuring: How to tell Clojure to associate names with values in a list, map, set or vector.
* fn: An anonymous function.
    * # can also define it concisely using reader macros.
    * & can help identify multiple arguments passed into an anonymous function
* Function calls: expressions that have a function expression as the operator. (get [1, 2, 3] 2)
* Marco calls: Can't be passed into functions as an argument.
* Predicate function: A function whose return value is evaluated for truth or false.
* Rest parameter (&): A single argument after the ampersand (& bikes) means you can pass in as many arguments as you want and have the result return them all as a list.
* Special forms: They don't always evaluate all of their operands. Examples would be if, def, let, loop, fn, do and recur. Can't be passed into functions as an argument.
* Sequence abstraction: A collection of elements organized in linear order. Functions that operate on seq include map, reduce, filter, etc. (Recall they all use the seq library for looking up how to handle the passed-in data structure.)
    * Core seq functions:
        * first: Returns the value for the requested node. 
        * rest: Returns the remaining values after the requested node.
        * cons: Adds a new node with the given value to the beginning of the list.
    * Infinite seq: 
    * Lazy seq (like map): Speed up traversals and are very efficient look ups. The lazy sequence it returns doesn't include any realized elements yet, but it has a recipe for generating its elements.

Control Flow
* if
* do
* when

Binding
* def
* let
* local binding: Any association between a symbol and a value that wasn't created by def.
