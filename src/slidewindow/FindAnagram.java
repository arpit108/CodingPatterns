package slidewindow;

import java.util.ArrayList;
import java.util.List;

public class FindAnagram {

    public static void main(String[] args) {
        String str = "abbcabc";
        String key = "abc";

        List<Integer> lst = getAnagramList(str.toCharArray(), key);

        System.out.println(lst);
    }

    private static List<Integer> getAnagramList(char[] charArr, String key) {
        int keyLength = key.length();
        int keySum = 0;
        for (Character el : key.toCharArray()) {
            keySum += el;
        }
        int start = 0;
        List<Integer> lst = new ArrayList<>();
        int sum = 0;


        for (int i = 0; i < charArr.length; i++) {
            sum += charArr[i];

            if (i >= keyLength-1) {
                if (sum == keySum) {
                    lst.add(i - (keyLength - 1));
                }
                sum -= charArr[start];
                start++;
            }

        }
        return lst;
    }
}
