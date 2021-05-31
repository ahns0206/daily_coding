package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * 20.11.30 이분탐색 - 징검다리
 * https://programmers.co.kr/learn/courses/30/lessons/43236
 * n개만큼 바위 제거하고 바위 사이 최솟값 중 최댓값을 구하는 것
 */

@Slf4j
public class Lessons43236_이분탐색_징검다리 {

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);

        // start : 바위 사이 최솟값
        // end : 바위 사이 최댓값
        int start = 1, end = distance, mid;

        while (start <= end) {
            mid = (start + end) / 2;

            int cur = 0;
            int removeRocks = 0; //제거하는 바위 갯수

            for (int i = 0; i < rocks.length; i++) {
                //바위 사이 최소거리(mid)를 정하고, 최소거리보다 작으면 제거
                if (rocks[i] - cur < mid) {
                    removeRocks++;
                } else {
                    cur = rocks[i];
                }
            }

            if (removeRocks > n) { // 제거하는 바위 갯수가 n보다 크면 거리 좁히기
                end = mid - 1;
            } else { // 제거하는 바위의 갯수가 n과 같거나 작으면 거리 늘리기
                start = mid + 1;
            }
        }
        answer = end;

        return answer;
    }

    @Test
    public void test() {
        assertEquals(4, solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }
}
