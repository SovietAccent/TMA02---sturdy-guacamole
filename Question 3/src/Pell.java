import java.util.Arrays;

public class Pell {

    // (a)
    private static final int COUNT = 10;
    public int[] pellNums;

    //(b)
    public Pell()
    {
        pellNums = new int[COUNT];
    }

    //(c)
    public int calculatePellNumAt(int n)
    {
        int pellMinOne = 1;
        int pellMinTwo = 0;
        int pellNumber = 0;

        for(int i = 3; i <= n; i++) {
            pellNumber = 2 * pellMinOne + pellMinTwo;
            pellMinTwo = pellMinOne;
            pellMinOne = pellNumber;
        }
        return pellNumber;
    }

//    (d)
    public void populatePellNums()
    {
        pellNums[0] = 0;
        pellNums[1] = 1;

        for (int i = 2; i < COUNT; i++) {
            pellNums[i] = calculatePellNumAt(i + 1);
        }
    }

    /*
    test class to print pellNums - remove before completion!
     */
    public void printPellNum()
    {
        System.out.println(Arrays.toString(pellNums));
    }

    //(e) version 2  // THIS MIGHT BE WRONG - REVIEW AFTER USING TESTPAD
    public double estimateRoot2(int n)
    {
        if (n < 2 || n > pellNums.length) {
            return 0.0;
        }

        double doublePellNum = pellNums[n - 1]; // Pn
        double doublePellNumMinusOne = pellNums[n - 2]; // Pn-1

        return (doublePellNum + doublePellNumMinusOne) / doublePellNum;
    }

    //(f) convergence
    public void showConvergence()
    {
        for (int i = 2; i <= COUNT; i++){
            System.out.println(estimateRoot2(i));
        }
    }

    //(g)
    public int findLength(double aPrecision)
    {
        //populate pellNums with COUNT.
        populatePellNums();

        //create a variable to hold the value of the square root of two.
        double sqrt2 = Math.sqrt(2);

        for (int i = 0; i < COUNT; i++) {
           double estimateOfSqrt2 = estimateRoot2(i);

           double error = Math.abs(sqrt2 - estimateOfSqrt2);

            if(error < aPrecision) {

                return i;
            }
        }
        return -1;
    }

}
