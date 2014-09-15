Modoku
======

Modoku is a a graphical application that allows you to play a game of boggle and then solves the board for you!

![Modoku Logo](/regles.jpg)

##Algorithm

Using a a prefix tree or trie data structure allows us to significantly cut down on the enormous search space on the board. The reasoning behind this is that, if a word "abc" does not occur as a prefix to any word in the dictionary there is no reason to keep searching for words after we encounter "abc" on the board. 

Here are the algorithm steps:

1.  Insert all words in the dictionary file into a prefix tree data structure in memory.
2.  Using backtracking, search the board for words.
3.  If a word is found and it contains 2 or more letters, search the prefix tree for the word.
4.  If searching was not successful in the previous step, return from this branch of the backtracking stage. (There is no point in continuing to search this branch, as this is neither a word nor the prefix of an exiting word).
5.  If searching was successful in step 3, continue searching by constructing more words along this branch of backtracking and stop when the leaf node has been reached in the prefix tree. (at that point there is nothing more to search).
6.  Repeat steps 2-5 as long as there are more words to search in the backtracking.

##Complexity

Building a prefix tree out of the dictionary words is O(W * L), where W is the number of words in the dictionary and L is the maximum length of a word in the dictionary.

Searching the board will be of the same order as we are not really searching words that are not in the dictionary. But it actually more work than that as we still need to backtrack along the board to construct new words until we can consult the dictionary prefix tree to know whether it exists or not.

