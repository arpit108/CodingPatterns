package twopointer;

import java.util.ArrayList;
import java.util.List;

public class TargetSum {

    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 11};
        int targetSum = 11;

        List<Integer> lst = getTargetSumIndices(arr, targetSum);
        System.out.println(lst);
    }

    private static List<Integer> getTargetSumIndices(int[] arr, int targetSum) {

        int start = 0;
        int end = arr.length - 1;
        List<Integer> resultIndices = new ArrayList<>();


        while (start <= end) {
            if (arr[start] + arr[end] == targetSum) {
                resultIndices.add(start);
                resultIndices.add(end);
                break;
            } else if (arr[start] + arr[end] > targetSum) {
                end--;
            } else {
                start++;
            }


        }
return resultIndices;

    }


}
