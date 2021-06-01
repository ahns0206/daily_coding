package com.algo.top50.stringandarray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*원점에서 가장 가까운 k개의 좌표 구하기
거리 공식=(x2-x1)^2 + (y2-y1)^2*/
/*PriorityQueue : 일반 Queue는 stack과 달리 FIFO이나,
PriorityQueue는 우선순위가 높은게 FIFO되는 자료구조로
heap으로 구성된 이진트리 구조로 heap이기에 시간 복잡도는 O(NLogN)*/
public class KClosest_09 {

    Comparator<int[]> Comp = new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            // TODO Auto-generated method stub
            return ((a[0] * a[0]) + (a[1] * a[1])) - ((b[0] * b[0]) + (b[1] * b[1]));
        }

    };

    public static void main(String[] args) {
        KClosest_09 a = new KClosest_09();
//        int[][] points = {{1, 3}, {-2, 2}};
//        int k = 1;
		int[][] points = {{3, 3},{5, -1},{-2, 4}};
		int k = 2;

        int[][] result = a.solve(points, k);
        a.print(result);
    }

    public int[][] solve(int[][] points, int k) {
        int[][] result = new int[k][2];

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b)
                -> (((a[0] * a[0]) + (a[1] * a[1])) - (b[0] * b[0]) + (b[1] * b[1])));
        for (int[] point : points) {
            priorityQueue.offer(point);
        }

        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }

        return result;
    }

    public int[][] solve1(int[][] points, int k) {
//		Queue<int[]> pQueue = new PriorityQueue<>(points.length, Comp);
        Queue<int[]> pQueue = new PriorityQueue<>((a, b) -> ((a[0] * a[0]) + (a[1] * a[1])) - ((b[0] * b[0]) + (b[1] * b[1])));
        int[][] result = new int[k][2];
        int index = 0;

        for (int[] p : points) {
            pQueue.offer(p);
        }
        while (index < k) {
            result[index] = pQueue.poll();
            index++;
        }
        return result;

    }

    /*참고
     * Arrays.sort 사용
     * Time: O(NlogN)
     */
    public int[][] solve2(int[][] points, int K) {
        Arrays.sort(points, (a, b) -> ((a[0] * a[0]) + (a[1] * a[1])) - ((b[0] * b[0]) + (b[1] * b[1])));
        return Arrays.copyOfRange(points, 0, K);
    }

    public void print(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print("{");
            for (int j = 0; j < 2; j++) {
                if (j == 1)
                    System.out.print(", " + result[i][j]);
                else
                    System.out.print(result[i][j]);
            }
            System.out.println("}");
        }
    }
}
