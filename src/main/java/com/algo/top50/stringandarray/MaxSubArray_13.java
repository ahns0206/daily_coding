package com.algo.top50.stringandarray;

//subarray 중에 합이 제일 큰 수 return
public class MaxSubArray_13 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; //4, -1, 2, 1
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int newSum = nums[0];
        int maxSum = nums[0];

        for(int i=1; i<nums.length; i++) {
            newSum = Math.max(nums[i], newSum+nums[i]);
            maxSum = Math.max(maxSum, newSum);
        }

        return maxSum;
    }

    public static int maxSubArray2(int[] nums) {
        int newSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //새로운 array max sum 값 = Math.max(새로운값, 새로운값 + subArray)
            newSum = Math.max(nums[i], newSum + nums[i]);
            //array max sum 값 저장
            maxSum = Math.max(maxSum, newSum);
        }
        return maxSum;
    }

    public static int maxSubArray_dp(int[] nums) {
        int[] dp = new int[nums.length];// dp[i] means the maximum subarray ending with nums[i];
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

}


