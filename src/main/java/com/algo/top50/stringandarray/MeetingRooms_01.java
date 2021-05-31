package com.algo.top50.stringandarray;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 문제 1
 * Time Complexity: O(n logn n)
 * Space Complexity : O(1)
 */
@Slf4j
public class MeetingRooms_01 {

    static class Interval {
        int start;
        int end;

        Interval() {
            this.start = 0;
            this.end = 0;
        }

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public static void main(String[] args) {
        MeetingRooms_01 a = new MeetingRooms_01();

        Interval in1 = new Interval(15, 20);
        Interval in2 = new Interval(5, 10);
        Interval in3 = new Interval(0, 30);

        Interval[] intervals = {in1, in2, in3};
        System.out.println(a.solve2(intervals));
    }

    public boolean solve2(Interval[] intervals) {
        if (intervals == null) return false;
        // sort
        log.debug(">> before");
        print(intervals);
        Arrays.sort(intervals, comp2); //Arrays.sort는 모든 데이터 타입에서 O(nlogn)
        log.debug(">> after");
        print(intervals);

        //check
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
    }

    Comparator<Interval> comp2 = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start; //오름차순
        }
    };

    public void print(Interval[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            Interval in = intervals[i];
            log.debug(in.start + " " + in.end);

        }
    }
}
