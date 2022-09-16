package spellchecker;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Dictionary implements IDictionary{

    private Set<String> dictionary;

    public Dictionary(Set<String> dictionary) {
        this.dictionary = getWords();
    }


    protected TreeSet<String> getWords() {

        TreeSet<String> wordSet = new TreeSet<>();

        try(Scanner sc = new Scanner(new File(WORDS))) {

            sc.useDelimiter(",|\\r|\\n");
            while (sc.hasNext()) {
                wordSet.add(sc.next());
            }

            return wordSet;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }


    @Override
    public boolean isSpellingCorrect(String word) {

        return dictionary.contains(word);
    }

}
