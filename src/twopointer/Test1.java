package twopointer;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        int sum=9;

        List<Integer> result=isSumExist(arr,sum);
        System.out.println(result);

    }

    private static List<Integer> isSumExist(int[] arr, int sum) {

        int i=0,j=arr.length-1;
        List<Integer> lst=new ArrayList<>();

        while(i<j)
        {
            int twoPointerSum=arr[i]+arr[j];

            if(twoPointerSum==sum)
            {
                lst.add(arr[i]);
                lst.add(arr[j]);
                return lst;
            }else if(twoPointerSum>sum)
            {
                j--;
            }else
            {
                i++;
            }

        }
        return null;


    }

}
