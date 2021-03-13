package mergeinterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeAllInterval {

    public static void main(String[] args) {
        List<Interval> lst = new ArrayList<>();
//[1,4], [2,6], [3,5]
        Interval in1 = new Interval(1, 4);
        Interval in2 = new Interval(2, 6);
        Interval in3 = new Interval(3, 5);

        lst.add(in1);
        lst.add(in2);
        lst.add(in3);

        List<Interval> mergedInterval = getMergedInterval(lst);
        for (Interval interval : mergedInterval)
            System.out.print(interval + " ");

    }

    private static List<Interval> getMergedInterval(List<Interval> intervals) {

        List<Interval> mergedIntervals = new ArrayList<>();

        Collections.sort(intervals, ((a, b) -> a.start- b.start));

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);

            if (interval.start < end) {
                end = Math.max(end, interval.end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }


        }
        mergedIntervals.add(new Interval(start, end));

    return mergedIntervals;
    }


}
