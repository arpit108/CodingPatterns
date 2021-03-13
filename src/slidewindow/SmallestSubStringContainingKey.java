package slidewindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubStringContainingKey {

    public static void main(String[] args) {
        String str = "aabdec";
        String key = "abc";

        String result = findSmallestSubStringContainingKey(str, key);
        System.out.println(result);
    }

    private static String findSmallestSubStringContainingKey(String str, String key) {

        Map<Character, Integer> map = new HashMap<>();

        for (char el : key.toCharArray()) {
            map.put(el, map.getOrDefault(el, 0) + 1);
        }
        int start = 0;
        while(map.containsKey(str.charAt(start)))
        {
         start++;
        }


        int end=start;
        while (map.isEmpty()) {
            char element = str.charAt(end);
            if (map.containsKey(element)) {
                map.put(element, map.get(element) - 1);

                if (map.get(element) == 0)
                    map.remove(element);
                end++;

            }


        }

return "";
    }

}
