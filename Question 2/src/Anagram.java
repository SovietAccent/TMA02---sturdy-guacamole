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
        // and ensure that aWord and anotherWord are both equal in length
        if (aWord.isEmpty() || anotherWord.isEmpty() || aWord.length() != anotherWord.length()) {
            return false;
        }

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

    /**
     * (g)
     */
    public void crossReference() {
        //create a new TreeMap to hold the cross-referenced anagrams
        TreeMap<String, TreeSet<String>> transformedAnagrams = new TreeMap<>(); // Step 1

        //iterate through the original set of anagrams
        for (String key : anagrams.keySet()) {
            TreeSet<String> currentAnagram = anagrams.get(key);

            // add the keys from the currentAnagram to the transFormedAnagram
            transformedAnagrams.computeIfAbsent(key, k -> new TreeSet<>()).addAll(currentAnagram);

            for (String value : currentAnagram) {
                transformedAnagrams.computeIfAbsent(value, k -> new TreeSet<>()).addAll(currentAnagram);

            }
        }
        // Update the original anagr ams map with the transformed data
        anagrams = transformedAnagrams; // step 5
    }
}