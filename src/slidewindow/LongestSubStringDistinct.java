package slidewindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringDistinct {

    public static void main(String[] args) {

        String str = "abccde";
        int result = findLongestDistinctSubString(str);
        System.out.println(result);

    }

    private static int findLongestDistinctSubString(String str) {

        int start = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < str.length(); i++) {
            char element = str.charAt(i);
            map.put(element, map.getOrDefault(element, 0) + 1);

            while (map.get(element) > 1) {

                char startEl = str.charAt(start);
                map.put(startEl, map.get(startEl) - 1);
                if (map.get(startEl) == 0) {
                    map.remove(startEl);
                }
                start++;

            }

            maxLength = Math.max(maxLength, i - start + 1);


        }


        return maxLength;

    }
}
