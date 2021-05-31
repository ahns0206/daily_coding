package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 20.07.24 완전탐색 - 모의고사
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 * 데이터 삽입/삭제 시 인근 노드 참조값만 수정하기에 빠르나, 데이터 조회가 느리다.
 *
 */
@Slf4j
public class Lessons42840_완전탐색_모의고사 {

    int[] one = {1, 2, 3, 4, 5};
    int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    int[] win = {0, 0, 0};

    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<Integer>();

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) {
                win[0]++;
            }
            if (answers[i] == two[i % two.length]) {
                win[1]++;
            }
            if (answers[i] == three[i % three.length]) {
                win[2]++;
            }
        }

        int maxValue = Math.max(Math.max(win[0], win[1]), win[2]);
        if (maxValue == win[0]) {
            answer.add(1);
        }
        if (maxValue == win[1]) {
            answer.add(2);
        }
        if (maxValue == win[2]) {
            answer.add(3);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void test() {
//        int[] array = {1, 2, 3, 4, 5};
        int[] array = {1, 3, 2, 4, 2};
        int[] result = this.solution(array);
        log.debug("result : " + Arrays.toString(result));
    }
}
