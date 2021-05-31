package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 20.08.01 스택/큐 - 다리를 지나는 트럭
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 * 모든 트럭 언제 건너려면 몇초? 1초 1만큼, 무게 견딤
 */
@Slf4j
public class Lessons42583_큐_다리를지나는트럭_giveup {
    static final int bridge_length1 = 2;
    static final int weight1 = 10;
    static final int[] truck_weights1 = {7, 4, 5, 6};
//    1 0
//    2 7 //다음꺼 더했을떄 weight 넘는 경우
//    1 4
//    1 4/5
//    1 5
//    2 6 //마지막인 경우

    static final int bridge_length2 = 100;
    static final int weight2 = 100;
    static final int[] truck_weights2 = {10};
//    1   0
//    100 10

    static final int bridge_length3 = 100;
    static final int weight3 = 100;
    static final int[] truck_weights3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
//    1   0
//    1   10
//    1   10/10
//    ...
//    1   10/10/10/10/10/10/10/10/10
//    100   10/10/10/10/10/10/10/10/10/10

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int total_weight;

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < truck_weights.length; i++) {
            total_weight = 0;
            for (int truck_weight : queue) { //다리 위 트럭 무게 측정
                total_weight += truck_weight;
            }

            //새 트럭 추가가 가능한 경우 다리 위 추가
            if (weight >= total_weight + truck_weights[i]) {
                total_weight += truck_weights[i];
                queue.add(truck_weights[i]);
            } else {
                answer += 1;
            }

            //마지막 트럭이거나, 다음 트럭이 추가되면 무게 초과하거나,
            if ((i == truck_weights.length - 1 && queue.size() > 0)
                    || weight < total_weight + truck_weights[i + 1]) {
                answer += bridge_length;
                queue.poll();
            } else {
                answer += 1;
            }

        }

        log.debug("다리를 건너는 트럭 : {}, 경과시간 : {}", truck_weights, answer);

        return answer;
    }

    @Test
    public void test() {
        assertEquals(8, this.solution(bridge_length1, weight1, truck_weights1));

        assertEquals(101, this.solution(bridge_length2, weight2, truck_weights2));

        assertEquals(110, this.solution(bridge_length3, weight3, truck_weights3));
    }
}
