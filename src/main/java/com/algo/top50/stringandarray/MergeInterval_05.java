package com.algo.top50.stringandarray;

import java.util.*;

public class MergeInterval_05 {

    static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public static void main(String[] args) {
//		int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        MergeInterval_05 a = new MergeInterval_05();
		List<Interval> list = a.merge(intervals);

        a.print(list);
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) return intervals;

        // Comparator 오름차순 sort
        Collections.sort(intervals, comp);
        // 람다식 오름차순 sort
//		Collections.sort(intervals, (a,b) -> a.start-b.start);

        List<Interval> result = new ArrayList<Interval>();
        Interval before = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (before.end >= current.start) {
                before.end = Math.max(current.end, before.end);
            } else {
                result.add(before);
                before = current;
            }
        }

        if (!result.contains(before)) {
            result.add(before);
        }

        return result;
    }

    Comparator<Interval> comp = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    };

    void print(List<Interval> list) {
        for (int i = 0; i < list.size(); i++) {
            Interval in = list.get(i);
            System.out.println(in.start + " " + in.end);
        }
    }

}
