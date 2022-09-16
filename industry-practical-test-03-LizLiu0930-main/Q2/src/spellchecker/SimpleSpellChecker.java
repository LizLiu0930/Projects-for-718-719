package spellchecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class is the simple spell checker, which uses a dictionary to check any words passed in from the constructor.
 * 
 * @author Write your UPI here
 *
 */
public class SimpleSpellChecker {

	private Map<String, Integer> userWords; // the words from a user 
	private IDictionary dictionary; // the dictionary to use for spelling check

	// TODO step 2 a and b. Complete the constructor so that
	// the dictionary for the class is assigned to the one from the IDictionary parameter of the constructor, and
	// the userWords for the class stores the words to check from the string parameter of the constructor.


	public SimpleSpellChecker(Map<String, Integer> userWords, IDictionary dictionary) {
		this.userWords = new TreeMap<>();
		this.dictionary = dictionary;
	}

	public SimpleSpellChecker(IDictionary dictionary, String wordsToCheck) {

		for(Map.Entry<String, Integer> entry : userWords.entrySet()) {
			String word = entry.getKey();
			if (word.equals(wordsToCheck)) {

			}
		}
	}
	
	// TODO step 2 c. Complete this method to return a list of possible misspelled words.
	public List<String> getMisspelledWords() {

		List<String> misspelledWords = new ArrayList<>();

		for(Map.Entry<String, Integer> entry : userWords.entrySet()) {
			String word = entry.getKey();
			char firstLetter = word.toLowerCase().charAt(0);
			if (!(dictionary.isSpellingCorrect(word)) && firstLetter >= 'a' && firstLetter <= 'z') {
				misspelledWords.add(word);
			}
		}

		return misspelledWords;
	}
	
	// TODO step 2 d. Complete this method to print a list of unique words from the userWords map.
	// The words should be printed in alphabetical order.
	public void printUniqueWords() {



	}
	
	// TODO step 2 e. Complete this method to return the frequency of a given occurring from the userWords map.
	public int getFrequencyOfWord(String word) {

		int frequency = 0;

		for(Map.Entry<String, Integer> entry : userWords.entrySet()) {
			String str = entry.getKey();
			if (entry.getKey().equals(word)) {
				frequency++;
			}
		}

		return frequency;
	}
}
