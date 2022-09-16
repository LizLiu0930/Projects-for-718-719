# Question One - A Music Store (30 marks)
We would like to build a simple music store application that imports information about different albums from a given csv file. The application will provide a summary of albums by genre. In addition, the application can export all album information to a csv file and print the latest albums to the console.

In this question, you are required to complete the instructions listed in steps 1 - 10 (task a - j in source code). The starting point is provided to you in the Q1 folder. You are required to create the following
classes:

- `TimePeriodInvalidException`
- `MusicTime`

You are also required to modify the following class:
- `Album`
- `MusicStore`

After completing these steps, the application should produce similar output as the following example:

```text
Welcome to the Auckland ICT Music Store
===============================
We have a total number of 487 albums available in store.
--------------------------------------------
Here is a quick summary of what we have in store for you :)
--------------------------------------------
Albums in 1960s: 7
Albums in 1970s: 19
Albums in 1980s: 66
Albums in 1990s: 171
Albums in 21st century: 224
--------------------------------------------
Exporting album information to a file was successful!
--------------------------------------------
Top 15 Highest-Number-of-Tracks albums in store
--------------------------------------------
Antichrist Superstar, METAL, tracks: 99
Anthology: Hey Ho, Let’s Go!, ALTERNATIVE, tracks: 58
Selected Works 1972–1999, ROCK, tracks: 53
Hooray for Boobies, ALTERNATIVE, tracks: 47
The Box Set Series, COUNTRY, tracks: 45
Beastie Boys Anthology: The Sounds of Science, HIP HOP/RAP, tracks: 43
The Essential Simon & Garfunkel, FOLK, tracks: 40
The Essential Billy Joel, POP, tracks: 36
Complete Clapton, POP, tracks: 36
The Essential Johnny Cash, ROCK, tracks: 36
The Essential Santana, ROCK, tracks: 33
The Essential Dave Brubeck, JAZZ, tracks: 31
The Essential Bob Dylan, FOLK, tracks: 30
The Essential Joe Satriani, ROCK, tracks: 30
Sounds of Summer: The Very Best of the Beach Boys, ROCK, tracks: 30
--------------------------------------------
Please enter a time between 1960 - 2015: 1930
Too old!
Please enter a time between 1960 - 2015: 2030
Too new!
Please enter a time between 1960 - 2015:
Empty Input
Please enter a time between 1960 - 2015: 1965
--------------------------------------------
All available SIXTIES albums:
The Who, "Tommy", Alternative, sixties
Harry Nilsson, "Aerial Ballet", Rock, sixties
The Kinks, "Kinks", Rock, sixties
The Marvelettes, "Please Mr. Postman", Pop, sixties
Donovan, "Donovan's Greatest Hits", Rock, sixties
The Velvet Underground, "The Velvet Underground & Nico", Rock, sixties
The Velvet Underground, "White Light/White Heat", Rock, sixties
```

To complete this question, perform the following steps:

1. Create one exception class, which extends the `Exception` class. The name of the class is `TimePeriodInvalidException`. It should have a constructor for receiving a `String` parameter. This string will be passed to the constructor of the superclass.

2. Create one separate `enum` type: `MusicTime`, which has the following set of constants:
    - `SIXTIES`, `SEVENTIES`, `EIGHTIES`, `NINETIES`, `TWENTY_FIRST_CENTURY`

3. Complete the `getPeriod()` method in the `MusicStore` class to convert the year of an album to the period of `MusicTime` type. The conversions are as follows:

    - **1960 - 1969:** `SIXTIES`
    - **1970 - 1979:** `SEVENTIES`
    - **1980 - 1989:** `EIGHTIES`
    - **1990 - 1999:** `NINETIES`
    - **2000 - 2015:** `TWENTY_FIRST_CENTURY`

4. You will find a csv file named "albums.csv" in the main folder. This file contains information for different albums. The following screenshot shows the first 7 album entries and the heading of the csv file. **Note that the first line of the file is the heading. The file uses semicolon(;) as the common delimiter instead of comma (,)**.

    ```text
    ID;Album;Genre;Artist;Year Released;Number of Tracks;Number of Discs
    1;311;Alternative;311;1995;14;1
    2;As Nasty As They Wanna Be;Hip Hop/Rap;2 Live Crew;1989;18;1
    3;Pictures of a City – Live in New York;Rock;21st Century Schizoid Band;2006;15;2
    4;The Better Life;Rock;3 Doors Down;2000;11;1
    5;Hate Made Me;Metal;8 Foot Sativa;2002;12;1
    6;A Flock Of Seagulls;Pop;A Flock Of Seagulls;1982;11;1
    7;Mer de Noms;Alternative;A Perfect Circle;2000;12;1
    ```

    Complete the `getAlbums()` method in the MusicStore class so that it uses a `BufferedReader` to read the file with the given `filePath` and create albums for the music store. Here is some pseudocode to help you complete this method:

    - Declare and initialize a list of `Album` objects

    - While you're going through each album entry from the CSV file, use the `createAlbum()` method to create a new `Album` object.

    The `createAlbum()` method takes a `String` array as a parameter. You will need to first split each entry from a `String` into a `String[]`, and then pass this array to `createAlbum()`.

    Then, add each album object to the list of `Album` objects that you created at the beginning of the method.

    - If any other exception is caught (e.g. `IOException`), print its error message.

    - Return the list of `Album` objects at the end of the method.

5. Complete the `getTotalByPeriod()` method in the MusicStore class. The method takes a list of albums and a period. It then counts and returns the total number of albums belonging to the given period from the given list.

6. Complete the `exportAlbumsToFile()` method in the `MusicStore` class. The method takes a list of albums and a `filePath`. The method uses a `BufferedWriter` to write information about each album from the list to the given `filePath`.

    The format of each album information is: `artist`, `"album title"`, `genre`, `period`

    The method returns `true` if there are no exceptions. Otherwise, the method returns `false`.

    **Hint:** You can call the `toString()` method from each `Album` object when writing album information to the file. You will find a text file named "albumSummary.txt" in the main folder as an example of the expected output file.

7. Complete the `printTopNumTrackAlbums()` method in the MusicStore class so that it prints the top 15 albums with the highest number of tracks to the console.

    The order should be in descending order with respect to the number of tracks. If the number is the same, then the order should be in alphabetical order of the genre. The format of each album information printed to the console is: album title, GENRE, tracks: tracks

    **Note:** To get full marks for this question, you must implement the `Comparable` interface to sort the given list of albums. GENRE should be printed with all capital letters.

8. Complete the `validPeriod()` method in the `MusicStore` class so that it converts the given `String` `yearInput` to an integer.

    If the String is empty, a `TimePeriodInvalidException` will be thrown, with the message "Empty Input". If the `String` cannot be converted to an integer, a
`TimePeriodInvalidException` will be thrown, with the message "Must be a number". If the year is less than 1960 or greater than 2015, a `TimePeriodInvalidException` will be thrown, with the message "Too old!" or "Too new!" respectively.

9. Modify the `getUserTimePeriodChoice()` method in the `MusicStore` class to handle exceptions. The method should catch the `TimePeriodInvalidException` and print the error message to the console.

10. Complete the `printAlbumsByPeriod()` method in the `MusicStore` class. This method takes a list of albums and a specific `MusicTime` period and prints out all albums in the given period.

## Marking guide
Question one will be marked according to the following criteria:
- **Exception class**: 1 mark
- **Enum class**: 1 mark
- **getPeriod()**: 2 marks
- **getAlbums()**: 8 marks
- **getTotalByPeriod()**: 3 marks
- **exportAlbumsToFile()**: 4 marks
- **printTopNumTrackAlbums()**: 3 marks
- **validPeriod()**: 2 marks
- **getUserTimePeriodChoice()**: 2 marks
- **printAlbumsByPeriod():** 2 marks
- **Code style, compilation without errors**: 2 marks
- **Total**: 30 marks


# Question Two - A Spell Checker (30 marks)
We would like to build a simple spellchecker application that will analyse a given text for possible misspellings. The spellchecker will provide a summary of the given text, including a list of unique words from the given text and the list of possible misspelled words. Since we will be using a small dictionary of words, the given text may contain words that are legal but may be interpreted as misspelled by the spellchecker.

In this question, you are required to complete the instructions listed in steps 1 - 2. The starting point is provided to you in the Q2 folder. You are required to create a `Dictionary` class and to modify the `SimpleSpellChecker` class.

After completing these steps, the spellchecker application should produce output similar to that shown here:

```text
Welcome to Simple Spell Checker
================================
Please enter the text you like to check: No duck and no plane here!!! Btw, final
project will be between 7th Oct to 2nd Nov 2022.
--------------------------------
Please enter any word you like: test
--------------------------------
Spell Checker Summary
--------------------------------
The misspelled words from the text are:
[Btw, No, Nov, Oct]
--------------------------------
The unique words are:
2022
2nd
7th
Btw
No
Nov
Oct
and
be
between
duck
final
here
no
plane
project
to
will
--------------------------------
The frequency for the word "test" to occur in the given text is: 0
```

1. Create a class named `Dictionary`, which implements the provided `IDictionary` interface.

    - Your class should declare a private `Set` field. The type of elements in the set will be Strings. Name this field `dictionary`. 

    - Create a constructor for the `Dictionary` class. Within the constructor, initialize your dictionary field to a new `TreeSet` object. Then, add each word from the given `WORDS` string (in the `IDictionary` interface) to the set. **Hint:** Remember to split the `WORDS` string by the delimiter **","**, and add each element in the resulting array to the set.

    - Complete the `isSpellingCorrect()` method in the `Dictionary` class. This method takes a `String` as a parameter, and should return a boolean indicating whether the given string is in the dictionary set.

2. Complete the `SimpleSpellChecker` class so that the program compiles and produces the correct output.

   - Within the constructor, appropriately set the `dictionary` instance variable to the provided `IDictionary`.

   - Within the constructor, set the `userWords` `Map` instance variable to a new instance of an appropriate `Map` class. Then, populate the map with all the words in the given `wordsToCheck` string. The map should relate words (keys) with their frequencies in the given text (values). **Hint:** Split `wordsToCheck` into an array of strings, then add each element in the array to the `userWords` map appropriately. You may use "`[\\s\\W]+`" as a delimiter.

   - Complete the `getMisspelledWords()` method to return a list of possible misspelled words. The method should loop through all keys in the `userWords` map. If that word isn’t spelled correctly (as determined by the dictionary's `isSpellingCorrect()` method), the word should be added to the list of words to return. **Note:** If the given word begins with a number (i.e. the characters from ‘0’ to ‘9’), we won't regard those words as being misspelled - they should not be added to the result list.

   - Complete the `printUniqueWords()` method, which should print all words in the `userWords` map. These words should be printed in alphabetical order. Words starting in uppercase should appear before words starting in lowercase. **Hint:** Consider the type of `Map` you initialized at the beginning of this step. If you choose the correct one, this step is very easy! If not, you can change it now.

   - Complete the `getFrequencyOfWord()` method, which should return the frequency of the given word in the original text. The data should be obtained from the `userWords` map. If the given word doesn't exist in the map, this method should return 0.

## Marking guide
Question two will be marked according to the following criteria:
- **Created Dictionary class implementing correct interface**: 2 marks
- **Dictionary constructor**: 5 marks
- **isSpellingCorrect()**: 3 marks
- **SimpleSpellChecker constructor**: 6 marks
- **getMisspelledWords()**: 5 marks
- **printUniqueWords()**: 4 marks
- **getFrequencyOfWord()**: 3 marks
- **Code style, compilation without errors**: 2 marks
- **Total**: 30 marks
