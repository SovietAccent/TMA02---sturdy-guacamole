public class Main {
    public static void main(String[] args) {

        Pell pell = new Pell();

        pell.printPellNum();

        System.out.println(pell.calculatePellNumAt(3));

        pell.populatePellNums();

        pell.printPellNum();

        System.out.println();


        pell.showConvergence();

        System.out.println();

        pell.findLength(0.9);


    }
}