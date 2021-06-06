package com.algo.top50.stringandarray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
1. 배열 오름차순 정렬
2. PriorityQueue, k=2
 */
public class KthLargestElementInArray_19 {

    Comparator<Integer> Comp = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            // TODO Auto-generated method stub
            return a - b;
        }
    };

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

//        System.out.println(solve(nums, k));
        System.out.println(solve_pq(nums, k));
    }

    public static int solve(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        return nums[n - k];
    }

    public static int solve_pq(int[] nums, int k) {
//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comp);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> a - b);

        for (int val : nums) {
            pq.offer(val); //값 추가
            if (pq.size() > k) {
                pq.poll(); //값을 반환하고 제거
            }
        }
        return pq.peek(); //값 참조
    }

	public static void print(int[] nums) {
		for (int i : nums)
			System.out.println("i " + i);
	}
}
