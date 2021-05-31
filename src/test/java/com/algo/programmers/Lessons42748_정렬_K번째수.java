package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * 20.07.24 정렬 - K번째수
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 * 배열 : 내부 인덱스를 이용하여 자료 검색시 빠르나, 데이터 삽입/삭제 시 비용이 많이 든다
 */
@Slf4j
public class Lessons42748_정렬_K번째수 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            log.debug("temp : " + Arrays.toString(temp));

            Arrays.sort(temp);
            log.debug("sort : " + Arrays.toString(temp));

            answer[i] = temp[commands[i][2] - 1];
            log.debug("answer[i] : " + answer[i]);
        }

        return answer;
    }

    @Test
    public void test() {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] result = this.solution(array, commands);
        log.debug("result : " + result);
    }

}
