package slidewindow;

import java.util.HashMap;
import java.util.Map;

public class LongestStringwithKReplacement {
    public static void main(String[] args) {
        String str = "abccde";
        int k = 1;

        int result = getLongestStringwithKReplacement(str, k);
        System.out.println(result);


    }

    private static int getLongestStringwithKReplacement(String str, int k) {
        int start = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int maxRepeatCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char element = str.charAt(i);
            map.put(element, map.getOrDefault(element, 0) + 1);
            maxRepeatCount = Math.max(maxRepeatCount, map.get(element));
            if (i - start + 1 - maxRepeatCount > k) {
                char startElement = str.charAt(start);
                map.put(startElement, map.get(startElement) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
