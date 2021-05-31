package com.algo.top50.stringandarray;

import java.util.HashMap;
import java.util.Map;

/*
 * 문제 3
 */
public class TwoSum_03 {

    public static void main(String[] args) {
        int[] nums = {2, 8, 11, 21};
        int target = 10;
        TwoSum_03 a = new TwoSum_03();

        int[] result = a.solve(nums, target);

        for (int i : result)
            System.out.println(i);
    }

    public int[] solve(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                result = new int[]{map.get(nums[i]) + 1, i + 1};
            else
                map.put(target - nums[i], i); //뺀 값, index (8, 0)
        }

        return result;
    }
}
