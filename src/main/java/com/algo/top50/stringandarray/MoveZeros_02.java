package com.algo.top50.stringandarray;

/*
 * 문제 2
 * Time Complexity: O(n)
 * Space Complexity : O(1)
 */
public class MoveZeros_02 {

    public static void main(String[] args) {
        // 1
        int[] nums = {0, 3, 2, 0, 8, 5};
        int index = 0;
        // 2. 0이 아닌값은 차례로 저장, 0이면 저장 없이 index만 증가
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        // 3. 나머지 0으로 세팅
        while (index < nums.length) {
            nums[index++] = 0;
        }
        // 4. 프린트
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
