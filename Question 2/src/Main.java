public class Main {
    public static void main(String[] args) {

        Anagram anagram = new Anagram();

        anagram.populate();

        anagram.print();

        System.out.println(anagram.areAnagrams("test", "test"));

        anagram.addAnagram("Test", "SETT");







    }
}