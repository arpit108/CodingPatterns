package twopointer;

import java.util.ArrayList;
import java.util.List;

public class ProductOfSubArray {


    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 10};
        int target = 30;

        List<List<Integer>> lst = findProductSubArrayLessThanTarget(arr, target);

        System.out.println(lst);


    }

    private static List<List<Integer>> findProductSubArrayLessThanTarget(int[] arr, int target) {

        List<List<Integer>> result = new ArrayList<>();


        for (int i = 0; i < arr.length; i++) {

            int product = 1;
            product *= arr[i];


            List<Integer> lst = new ArrayList<>();
            if (product < target) {
                lst.add(arr[i]);
                result.add(lst);
            }


        }
        return result;


    }


}
