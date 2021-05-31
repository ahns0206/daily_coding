package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * 20.08.01 정렬 - H-Index
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */
@Slf4j
public class Lessons42747_정렬_HIndex {
    //x번 이상 인용된 논문이 x편 이상, 나머지가 x편 이하일때 x의 최댓값

    //논문인용횟수
    private final int[] citations1 = {3, 0, 6, 1, 5}; //3
    private final int[] citations2 = {12, 11, 10, 9, 8, 1}; //5
    private final int[] citations3 = {6, 6, 6, 6, 6, 1}; //5
    private final int[] citations4 = {20, 21, 22, 23}; //4
    private final int[] citations5 = {4, 4, 4}; //3
//    0 5
//    1 4
//    2 3
//    3 3
//    4 2
//    5 2
//    6 1

    public int solution(int[] citations) {
        int answer = 0;
        int maxCitaiton = Arrays.stream(citations).max().getAsInt();
        int count = 0;

        for (int i = 0; i <= maxCitaiton; i++) {
            count = 0;
            for (int j = 0; j < citations.length; j++) {
                if (i <= citations[j]) count++;

                if (j == citations.length - 1
                        && i <= count
                        && i >= answer) {
                    answer = i;
                }
            }
        }

        return answer;
    }

    @Test
    public void test() {
        assertEquals(3, this.solution(citations1));

        assertEquals(5, this.solution(citations2));

        assertEquals(5, this.solution(citations3));

        assertEquals(4, this.solution(citations4));

        assertEquals(3, this.solution(citations5));
    }
}
