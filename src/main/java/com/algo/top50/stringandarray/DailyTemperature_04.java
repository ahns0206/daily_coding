package com.algo.top50.stringandarray;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/*
 * 문제 4
 */
public class DailyTemperature_04 {

    public static void main(String[] args) {
        int[] tempers = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures_stack1(tempers);      //stack : push, pop, peek, isEmpty
//        int[] res = dailyTemperatures_stack(nums);      //stack : push, pop, peek, isEmpty
//		int[] res = dailyTemperatures_stackandmap(nums);//map : put, get
//		int[] res = dailyTemperatures_back(nums);       //LinkedList : push, pop, peek, isEmpty
        System.out.println("====result===");
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] dailyTemperatures_stack1(int[] tempers) {
        int[] ret = new int[tempers.length];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < tempers.length; i++) {
            while (!stack.isEmpty() && tempers[stack.peek()] < tempers[i]) {
                int index = stack.pop();
                ret[index] = i - index;
            }
            stack.push(i);
        }
        return ret;
    }

    public static int[] dailyTemperatures_stack(int[] temper) {
        // data structure
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temper.length];

        for (int i = 0; i < temper.length; i++) {
            while (!stack.isEmpty() && temper[stack.peek()] < temper[i]) {
                int index = stack.pop();
                ret[index] = i - index;
            }
            stack.push(i);
        }
        return ret;
    }


    public int[] dailyTemperatures_stackandmap(int[] temper) {
        final int m = temper.length;
        final Map<Integer, Integer> next = new HashMap<>();
        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < m; i++) {
            while (!stack.empty() && temper[stack.peek()] < temper[i]) {
                next.put(stack.peek(), i - stack.pop());
            }
            stack.push(i);
        }

        final int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = next.getOrDefault(i, 0);
        }
        return ans;
    }

    public static int[] dailyTemperatures_back(int[] temper) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] ans = new int[temper.length];

        stack.push(temper.length - 1);
        for (int i = temper.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && temper[i] >= temper[stack.peek()])
                stack.pop();
            if (!stack.isEmpty())
                ans[i] = stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
