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

    //(e)
    public double estimateRoot2(int n)
    {
        double doublePellNum = pellNums[n];

        if (n == 0.0) {

        double doublePellNumMinusOne = pellNums[n - 1];
        double approxSqrtTwo = (doublePellNum + doublePellNumMinusOne) / doublePellNum;


        System.out.println(approxSqrtTwo);// for testing purposes - remove before final completion

        return approxSqrtTwo;
    }

}
