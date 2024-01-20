public class Main {
    public static void main(String[] args) {

        Anagram anagram = new Anagram();

        anagram.populate();

        anagram.print();

        anagram.addAnagram("saps", "asps");

        anagram.addAnagram("beat", "abet");

        anagram.addAnagram("beat", "beta");

        anagram.addAnagram("list", "sitl");

        anagram.addAnagram("list", "silt");

        anagram.addAnagram("test", "estt");

        anagram.addAnagram("test", "tste" );

        anagram.print();

        System.out.println();

        anagram.addAnagram("came", "acme");

        anagram.addAnagram("came", "mace");

        anagram.print();









    }
}