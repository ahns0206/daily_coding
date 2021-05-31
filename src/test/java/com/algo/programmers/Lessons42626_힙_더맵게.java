package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 20.08.14 힙 (같은 FIFO로 우선순위큐를 힙 대신 사용함)
 * add()  : PriorityQueue에 데이터 추가 (데이터 insert 순서나 우선순위는 고려되지 않고 저장됨)
 * poll() : 큐에서 우선순위가 가장 높은 요소(가장 작은 수)를 반환후 큐에서 삭제
 * peek() : 큐에서 삭제하지 않고 가장 우선순위가 높은 요소(가장 작은 수)를 조회
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */
@Slf4j
public class Lessons42626_힙_더맵게 {

    static final int[] scovile1 = {1, 2, 3, 9, 10, 12};

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++)
            priorityQueue.add(scoville[i]);

        int count = 0;
        while (priorityQueue.size() > 1 && priorityQueue.peek() < K) {
            int weakHot = priorityQueue.poll();
            int secondWeakHot = priorityQueue.poll();

            int mixHot = weakHot + (secondWeakHot * 2);
            priorityQueue.add(mixHot);
            count++;
        }

        if (priorityQueue.size() <= 1 && priorityQueue.peek() < K)
            count = -1;

        return count;
    }

    @Test
    public void test() {
        assertEquals(2, solution(scovile1, 7));
    }

    @Test
    @Ignore
    public void sideTest() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(5);
        priorityQueue.add(13);
        priorityQueue.add(2);
        priorityQueue.add(0);
        priorityQueue.add(21);

        log.debug(">> 1 : {}", priorityQueue.toString());

        priorityQueue.poll();

        log.debug(">> 2 : {}", priorityQueue.toString());

        priorityQueue.poll();

        log.debug(">> 3 : {}", priorityQueue.toString());

        log.debug(">> 4 : {}", priorityQueue.peek().toString());

        log.debug(">> 5 : {}", priorityQueue.toString());

        priorityQueue.poll();

        log.debug(">> 6 : {}", priorityQueue.toString());
    }
}
