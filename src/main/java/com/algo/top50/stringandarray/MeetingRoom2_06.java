package com.algo.top50.stringandarray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* PriorityQueue :
* - 힙으로 구성된 완전 이진트리인 우선순위 큐
* - 높은 우선순위의 요소를 먼저 꺼내서 처리
* 시간복잡도 : O(NlogN)
* */

public class MeetingRoom2_06 {

    static class Interval {
        int start, end;

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
        MeetingRoom2_06 a = new MeetingRoom2_06();

//        Interval[] intervals = {new Interval(5, 10), new Interval(15, 20), new Interval(0, 30)};

        Interval[] intervals = {new Interval(0, 30), new Interval(4, 9)
                , new Interval(5, 15), new Interval(10, 16)};

        System.out.println(a.solve(intervals));
    }

    public int solve(Interval[] intervals) {
        // start로 오름차순 정렬
//        Arrays.sort(intervals, Comp);
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        // 회의 종료시간 이른 우선순위 큐
        Queue<Interval> pq = new PriorityQueue<>((Interval a, Interval b) -> a.end - b.end);
        // 제일 이른시간 회의를 inqueue
        pq.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // 종료시간 가장 이른 회의의 종료시간과 겹치지 않는 경우
            // 회의실을 같이 쓸수 있기에 pq에서 dequeue
            if (pq.peek().end <= intervals[i].start) {
                pq.poll();
            }
            pq.add(intervals[i]);
        }

        return pq.size();
    }


    public int solve2(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, Comp);
        Queue<Interval> heap = new PriorityQueue<Interval>(intervals.length, Comp2);

        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval interval = heap.poll();
            if (interval.end <= intervals[i].start) {
                interval.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(interval);
        }
        return heap.size();


    }

    Comparator<Interval> Comp2 = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            // TODO Auto-generated method stub
            return o1.end - o2.end;
        }
    };

    Comparator<Interval> Comp = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            // TODO Auto-generated method stub
            return o1.start - o2.start;
        }
    };
}
