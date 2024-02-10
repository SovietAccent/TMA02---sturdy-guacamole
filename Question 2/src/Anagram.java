import java.util.TreeSet;
import java.util.TreeMap;

/**
 * (a)
 */

public class Anagram {

    public TreeMap<String, TreeSet<String>> anagrams;

    /**
     * (b)
     */

    public Anagram() {
        anagrams = new TreeMap<>();
    }

    /**
     * (c) - in this method, if the provided key is absent from the map, it will be added and stored as a key and the lambda
     * function will create a new TreeSet. The given value will then be associated with this key. If the key already exists, the
     * lambda function will not run and a new TreeSet will not be created as one currently exists. The provided value will then
     * be added to the associated TreeSet.
     */

    public void populate() {
        anagrams.computeIfAbsent("list", k -> new TreeSet<>()).add("silt");
        anagrams.computeIfAbsent("list", k -> new TreeSet<>()).add("slit"); //"list" already exists - a new TreeSet is not created - slit is added to the existing set.

        anagrams.computeIfAbsent("saps", k -> new TreeSet<>()).add("asps");
        anagrams.computeIfAbsent("saps", k -> new TreeSet<>()).add("pass");
        anagrams.computeIfAbsent("saps", k -> new TreeSet<>()).add("spas");

    }

    /**
     * (d)
     */
    public void print() {
        anagrams.forEach((key, values) -> {
            System.out.print(key + " - ");
            values.forEach(value -> System.out.print(value + " "));
            System.out.println();
        });
    }

    /**
     * (e)
     */

    public boolean areAnagrams(String aWord, String anotherWord) {

        //create a TreeSet for both words - this will sort the elements in a natural order
        TreeSet<Character> firstWord = new TreeSet<>();
        TreeSet<Character> secondWord = new TreeSet<>();

        // ensure that the given parameters are not empty and return false if this is the case
        if (aWord.isEmpty() || anotherWord.isEmpty()) {
            return false;
        }

        // ensure both words are lower case and have whitespaces removed to allow accurate comparison - this is
        // done outside the loop to prevent redundant computations.
        aWord = aWord.toLowerCase().trim();
        anotherWord = anotherWord.toLowerCase().trim();

        // add each character of the given parameters into a TreeSet - this ensures all characters are naturally sorted
        for (char c : aWord.toCharArray()) {
            firstWord.add(c);
        }

        for (char c : anotherWord.toCharArray()) {
            secondWord.add(c);
        }
        //return true if the words are anagrams, or return false if not.
        return firstWord.equals(secondWord);
    }


    /**
     * (f)
     */
    public void addAnagram(String aWord, String anAnagram) {   // Test to see if the given parameters are anagrams using the areAnagrams() method AND aWord is in the Anagram TreeMap
        if (areAnagrams(aWord, anAnagram)) {
            anagrams.computeIfAbsent(aWord, k -> new TreeSet<>()).add(anAnagram);
        }
    }

}

