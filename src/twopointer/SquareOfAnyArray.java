package twopointer;

import java.util.ArrayList;
import java.util.List;

public class SquareOfAnyArray {

    public static void main(String[] args) {
        int[] arr = {-3, -1, 0, 1, 2};
        List<Integer> result = getSquareOfArray(arr);
        System.out.print(result);
    }

    private static List<Integer> getSquareOfArray(int[] arr) {

        List<Integer> result = new ArrayList<>();
        int j = 0;
        while (j < arr.length) {
            if (arr[j] < 0)
                j++;
            else
                break;

        }
        int i = j - 1;
        while (j < arr.length && i >= 0) {

            int squareOfLeft = arr[i] * arr[i];
            int squareOfRight = arr[j] * arr[j];

            if (squareOfLeft < squareOfRight) {
                result.add(squareOfLeft);
                i--;
            } else {
                result.add(squareOfRight);
                j++;
            }
        }
        while (i >= 0) {
            result.add(arr[i] * arr[i]);
            i--;
        }
        while (j < arr.length) {
            result.add(arr[j] * arr[j]);
            j++;
        }
        return result;
    }
}
