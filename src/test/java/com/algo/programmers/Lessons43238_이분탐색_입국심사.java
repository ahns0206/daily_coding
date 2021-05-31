package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * 20.09.26 이분탐색 - 입국심사
 * https://programmers.co.kr/learn/courses/30/lessons/43238
 * 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 구하는 것
 *
 */

@Slf4j
public class Lessons43238_이분탐색_입국심사 {

    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long start = 0; // 탐색시간 최솟값
        long end = (long) n * times[times.length - 1]; // 탐색시간 최댓값(가장 오래 심사받는 경우)
        long mid; // 탐색 최소시간

        while (start <= end) {
            long countPeople = 0; // 입국심사한 사람의 수
            mid = (start + end) / 2;

            for (int time : times) {
                // 탐색 최소시간(mid)을 정하고, 탐색 최소시간보다 탐색시간이 작으면 입국심사 진행
                if (time > mid)
                    break;
                countPeople += mid / time;
            }

            if (countPeople >= n) { // 입국심사한 사람의 수가 n보다 크면 탐색시간 줄이기
                end = mid - 1;
                answer = mid; // 최소 탐색시간을 구하는 것이기에 answer은 mid
            } else { // 입국심사한 사람의 수가 n보다 작으면 탐색시간 늘리기
                start = mid + 1;
            }
        }

        return answer;
    }

    @Test
    public void test() {
        assertEquals(28, solution(6, new int[]{7, 10}));
    }
}