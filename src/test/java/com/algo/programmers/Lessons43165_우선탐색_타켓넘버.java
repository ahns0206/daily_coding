package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 20.09.26 우선탐색 - 타겟넘버
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 *
 * 이해 불가..
 */
@Slf4j
public class Lessons43165_우선탐색_타켓넘버 {

    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer = dfs(numbers, 0, 0, target);

        return answer;
    }

    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }

        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }


    @Test
    public void test() {
        assertEquals(5, solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
