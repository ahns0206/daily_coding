package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * 20.09.09 스택/큐 - 프린터
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */
@Slf4j
public class Lessons42587_스택큐_프린터 {

    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();

        for (int priority : priorities) {
            queue.add(priority);
        }

        int answer = 0;
        int count = 1;
        int maxInt = 10;
        int targetPriority = priorities[location];

        while (queue.size() > 0
                && queue.peek() != targetPriority
                && queue.peek() <= maxInt
                && targetPriority <= maxInt) {
            maxInt = queue.stream().mapToInt(i -> i).max().getAsInt();
            queue.poll();
            count++;
        }

        answer = (count + location) % priorities.length;

        return answer;
    }

    @Test
    public void test() {
        assertEquals(5, solution(new int[]{1, 1, 9, 1, 1, 1}, 2));
        assertEquals(1, solution(new int[]{2, 1, 3, 2}, 2));
    }

    @Test
    @Ignore
    public void testMod() {
        log.debug(">> : {}", (5 + 3) % 5);
    }
}
