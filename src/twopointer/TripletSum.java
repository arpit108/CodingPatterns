package twopointer;

import java.util.*;

public class TripletSum {

    public static void main(String[] args) {
        int[] arr = {-5, 2, -1, -2, 3};

        Set<List<Integer>> result = getTripletSum(arr);
        System.out.println(result);

       // System.out.println(23%10);


    }

    private static Set<List<Integer>> getTripletSum(int[] arr) {
       // Arrays.sort(arr);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];

                if (Arrays.binarySearch(arr, -sum) > 0) {

                   List<Integer> lst=new ArrayList<>();
                   lst.add(arr[i]);
                   lst.add(arr[j]);
                   lst.add(-sum);
                   lst.sort(Integer::compareTo);
                   result.add(lst);
                }

            }

        }
        return result;
    }

}
