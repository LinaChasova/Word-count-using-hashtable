# Word-count-using-hashtable
Data structure: MAP

You are given a text file input.txt that consists of multiple lines in English. You need to count distinct words (case insensitive) in this file considering constraints:
You should use your own hash table implementation. Use it to build a YourMap
Hash table is implemented using open addressing with quadratic probing technique.
You should consider text with (firstly) and without stoplist {a, the, in, at, to, on, not, for, 's, 'd, 're, is, are, am, has, I, we, you}. Count all words firstly, but then delete and recount.
Your result in output.txt should consist of the most frequent lowercase word and its wordcount. First line not considering stop-list. Second - consider stop-list. There's always only one most frequent word. 
