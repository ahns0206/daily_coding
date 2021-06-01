package com.algo.top50.stringandarray;

/*array 값을 숫자로 보고 +1 하기
문제 이해 : 뒷자리부터 체크, array[2]+1하고 값이 10되면 앞자리+1
 */
public class PlusOne_10 {

    public static void main(String[] args) {
//		int[] digits = {1,2,3};
//		int[] digits = {9,9,9};
//		int[] digits = {9,8,9};
//		int[] digits = {8,9,9};
//		int[] digits = {0,0,1};
//        int[] digits = {0, 0};
		int[] digits = {9,9,9};
//		int[] digits = {9,0,0,9};

        int[] result = plusOne1(digits);
        for (int i : result)
            System.out.println(i);
    }

    public static int[] plusOne1(int[] digits) {
        int carry = 1;
        int i = digits.length - 1;

        while (i >= 0 && carry == 1) {
            digits[i] = (digits[i] + carry) % 10;

            if (digits[i] == 0) {
                carry = 1;
            } else {
                carry = 0;
            }
            i--;
        }

        if (carry == 1) { //숫자 자릿수 늘어난 경우
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }
}
