package slidewindow;

import java.util.HashMap;
import java.util.Map;

public class LongestOnesSubString {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int k = 3;

        int result = findLongestOnesSubArray(arr, k);
        System.out.println(result);


    }

    private static int findLongestOnesSubArray(int[] arr, int k) {
        int start = 0;
        int maxRepeatOnes = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            map.put(element, map.getOrDefault(element, 0) + 1);
            maxRepeatOnes = Math.max(maxRepeatOnes, map.getOrDefault(1,0));
            if (i - start + 1 - maxRepeatOnes > k) {
                int startElement = arr[start];
                map.put(startElement, map.get(startElement) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, i - start + 1);

        }
        return maxLength;

    }


}
