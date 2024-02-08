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


}
