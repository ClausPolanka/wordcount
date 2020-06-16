Word counter
============
Application to count the number of words in a text. 
The app will ask the user for the text upon start. 
It will then output the number of words found in the text. 
Words are stretches of letters (a-z,A-Z). Sample usage:

    $ wordcount
        Enter text: Mary had a little lamb
        Number of words: 5

Not all words are relevant for counting. A list of stop words can be provided in the stopword.txt reource file - new line separated.

The application can be started with a filename to read the text from instead of entering it manually.

    $ wordcount mytext.txt
        Number of words: 4
Source
-------
https://ccd-school.de/coding-dojo/agility-katas/word-count-i/

Assumptions
===========
1. Input text is a single line
2. Stop words can be loaded from resource file only
3. Stop words file is mandatory
