package mergeinterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergedIntervals {

    public static void main(String[] args) {
        List<Interval> lst = new ArrayList<>();
        //[4,5], [2,3], [2,4], [3,5]
        lst.add(new Interval(4, 5));
        lst.add(new Interval(2, 3));
        lst.add(new Interval(2, 4));
        lst.add(new Interval(3, 5));

    //    List<Interval> result = getMergedInterval(lst);

        int minRooms = getMinRoomRequired(lst);
        System.out.println(minRooms);
    }

    private static int getMinRoomRequired(List<Interval> intervals) {
        if(intervals.size()<=1)
            return 1;

        Collections.sort(intervals, (a, b) -> a.start - b.start);


        Interval first = intervals.get(0);
        int start = first.start;
        int end = first.end;
        int conflicts = 1;

        for (int i = 1; i < intervals.size(); i++) {
            Interval element = intervals.get(i);

            if (element.start < end) {
                conflicts++;

                end=Math.min(end,element.end);

            } else {

                start = element.start;
                end = element.end;


            }


        }
        return conflicts;

    }

    private static List<Interval> getMergedInterval(List<Interval> intervals) {

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        Interval first = intervals.get(0);
        int start = first.start;
        int end = first.end;

        List<Interval> mergedIntervals = new ArrayList<>();
        for (int i = 1; i < intervals.size(); i++) {
            Interval element = intervals.get(i);

            if (element.start < end) {
                end = Math.max(end, element.end);
            } else {
                mergedIntervals.add(new Interval(start, end));

                start = element.start;
                end = element.end;


            }


        }

        mergedIntervals.add(new Interval(start, end));


        return mergedIntervals;

    }


}
