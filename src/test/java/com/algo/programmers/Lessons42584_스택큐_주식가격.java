package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * 20.08.14 스택/큐 - 주식가격
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */
@Slf4j
public class Lessons42584_스택큐_주식가격 {

    static final int[] prices = {1, 2, 3, 2, 3};

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;

                if (prices[i] > prices[j])
                    break;
            }
        }

        return answer;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{4, 3, 1, 1, 0}, solution(prices));
    }
}
