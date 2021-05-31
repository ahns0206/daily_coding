package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 20.08.01 정렬 - 가장 큰 수
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 * Integer.compare(x, y) : x < y (-1), x = y (0), x > y (1)
 */
@Slf4j
public class Lessons42746_정렬_가장큰수 {

    int[] intNumber1 = {6, 10, 2};
    int[] intNumber2 = {3, 30, 34, 5, 9};
    int[] intNumber3 = {0, 0};

    public String solution(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();

        for (int number : numbers) {
            list.add(number);
        }

        Collections.sort(list, (x, y) -> {
            String sx = String.valueOf(x);
            String sy = String.valueOf(y);
            return -Integer.compare(Integer.parseInt(sx + sy), Integer.parseInt(sy + sx));
        });

        if (list.get(0) == 0) {
            return "0";
        } else {
            for (Integer integer : list) {
                answer += String.valueOf(integer);
            }
        }

        return answer;
    }

    @Test
    public void test() {
        String answer = this.solution(intNumber1);
        log.debug("answer 1 : {}", answer);

        answer = this.solution(intNumber2);
        log.debug("answer 2 : {}", answer);

        answer = this.solution(intNumber3);
        log.debug("answer 3 : {}", answer);
    }
}
