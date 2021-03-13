package slidewindow;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        int[] arr = {1, 5, 9,20,21,45,67,87,90,100};
        int k = 5;

        List<Double> avgSum = getAvgSum(arr, k);
        System.out.println(avgSum);


    }

    private static List<Double> getAvgSum(int[] arr, int k) {
        List<Double> result = new ArrayList<>();
        int windowStart = 0;
        int sum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];
            if (windowEnd >= k-1) {
                result.add((double) sum / k);
                sum -= arr[windowStart];
                windowStart++;
            }

        }

        return result;

    }


}
