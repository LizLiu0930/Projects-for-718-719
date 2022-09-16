package spellchecker;

import java.util.Arrays;

/**
 * This the application for running the simple spell checker. Do not change the code in this class unless otherwise specified.
 * 
 * @author Yu-Cheng Tu
 *
 */
public class SimpleSpellCheckerApp {

	public static void main(String[] args) {

		System.out.println("Welcome to Simple Spell Checker");
		System.out.println("================================");
		System.out.print("Please enter the text you like to check: ");
		
		String userInput = Keyboard.readInput();
		SimpleSpellChecker sp = new SimpleSpellChecker(new Dictionary(), userInput);
		
		System.out.println("--------------------------------");
		
		System.out.print("Please enter any word you like: ");
		userInput = Keyboard.readInput();
		
		System.out.println("--------------------------------");
		System.out.println("Spell Checker Summary");
		System.out.println("--------------------------------");
		
		System.out.println("The misspelled words from the text are: ");
		System.out.println(Arrays.toString(sp.getMisspelledWords().toArray()));
		System.out.println("--------------------------------");
		System.out.println("The unique words are: ");
		sp.printUniqueWords();
		System.out.println("--------------------------------");
		System.out.println("The frequency for the word \"" + userInput + "\" to occur in the given text is: " + sp.getFrequencyOfWord(userInput));
	}

}
