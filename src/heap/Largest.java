package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Largest {

    public static PriorityQueue<Integer> getKLargestList(int[] num, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < num.length; i++) {
            if (i <= k - 1) {
                minHeap.add(num[i]);
            } else {
                if (num[i] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(num[i]);
                }
            }

        }

        return minHeap;

    }

    public static Integer getKSmallestNumber(int[] num, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < num.length; i++) {
            if (i <= k - 1) {
                maxHeap.add(num[i]);
            } else {
                if (num[i] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.add(num[i]);
                }
            }

        }

        return maxHeap.peek();

    }


    public static String getElementFrequency(String str) {

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());

        Map<Character, Integer> map = new HashMap<>();

        for (Character c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        maxHeap.addAll(map.entrySet());

        StringBuilder result = new StringBuilder(str.length());
        Map.Entry<Character, Integer> previousEntry =null;
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();

            if(previousEntry!=null && previousEntry.getValue()>0)
            {
                maxHeap.add(previousEntry);
            }


            result.append(currentEntry.getKey());

            currentEntry.setValue(currentEntry.getValue() - 1);
            previousEntry=currentEntry;

        }
        return result.length() == str.length() ? result.toString():"";


    }


}
