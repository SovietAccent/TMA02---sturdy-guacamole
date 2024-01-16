import com.sun.source.tree.Tree;

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

    public boolean areAnagrams(String aword, String anotherWord)
    {

    }

}

