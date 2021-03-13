import java.util.Arrays;

public class XOR {

    public static void main(String[] args) {
       // int[] num={1, 4, 2, 1, 3, 2, 3};

       /* int missingNumber=getMissingNumber(num);
        System.out.println(missingNumber);*/

        /*int result=getUniqueNumber(num);

        System.out.println(result);*/

        /*int num= 4;
        *//*int bitCount=getBitCount(num);
        System.out.println(bitCount);*//*

        System.out.println(num>>2);*/


        int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
        int[] results=findSingleNumbers(arr);

        System.out.println(results);

    }



    public static int[] findSingleNumbers(int[] nums) {
        // get the XOR of the all the numbers
        int n1xn2 = 0;
        for (int num : nums) {
            n1xn2 ^= num;
        }

        // get the rightmost bit that is '1'
        int rightmostSetBit = 1;
        while ((rightmostSetBit & n1xn2) == 0) {
            rightmostSetBit = rightmostSetBit << 1;
        }
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) // the bit is set
                num1 ^= num;
            else // the bit is not set
                num2 ^= num;
        }
        return new int[] { num1, num2 };
    }


    private static int getBitCount(int num) {

        int bitcount=0;
        int n=num;
        while(n>0)
        {
            bitcount++;
            n=n>>1;
        }

        int all_bit_set= (int) Math.pow(2,bitcount)-1;


        return num ^ all_bit_set;




    }

    private static int getUniqueNumber(int[] num) {

        int x1=num[0];
        for(int i=1;i<num.length;i++)
        {
            x1=x1^num[i];
        }

        return x1;

    }

    private static int getMissingNumber(int[] num) {

        int arrayLength=num.length+1;
        int x1=1;
        for(int i=2;i<=arrayLength;i++)
           x1=x1^i;

        int originalXor=num[0];
        for(int i=1;i<num.length;i++)
        {
            originalXor=originalXor^num[i];
        }

        return x1^originalXor;





    }


}
