package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * 20.08.10 스택/큐 - 다리를 지나는 트럭
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 * 큐 기능   (예외발생/null이나 false반환)
 * enqueue  (add/offer)
 * dequeue  (remove/poll)
 * peek     (element/peek)
 */
@Slf4j
public class Lessons42583_큐_다리를지나는트럭 {
    static final int bridge_length1 = 2;
    static final int weight1 = 10;
    static final int[] truck_weights1 = {7, 4, 5, 6};

    static final int bridge_length2 = 100;
    static final int weight2 = 100;
    static final int[] truck_weights2 = {10};

    static final int bridge_length3 = 100;
    static final int weight3 = 100;
    static final int[] truck_weights3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }

    @Test
    public void test() {
        assertEquals(8, this.solution(bridge_length1, weight1, truck_weights1));

        assertEquals(101, solution(bridge_length2, weight2, truck_weights2));

        assertEquals(110, solution(bridge_length3, weight3, truck_weights3));
    }
}
