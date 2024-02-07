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
        int pellMinOne = 2;
        int pellMinTwo = 1;
        int pellNumber = 0;

        for(int i = 3; i <= n; i++) {
            pellNumber = 2 * pellMinOne + pellMinTwo;
            pellMinTwo = pellMinOne;
            pellMinOne = pellNumber;
        }
        return pellNumber;
    }

    //(d)
//    public double estimateRoot2(int n)
//    {
//
//    }


}
