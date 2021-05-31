package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;

/**
 * 20.08.01 해시 - 완주하지 못한 선수
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 * 해시 : 내부 배열이 있기에 조회시 빠르며, 데이터 삽입/ 삭제시 내부 hash table 사용하여 비용이 많이 들지 않는다.
 * Map (key 중복 불가), List (선형), Set (비선형, 중복불가, 빠른검색, Linked시 순서보장), Tree (빠른검색, 순서비보장, 정렬가능, 이진탐색)
 */
@Slf4j
public class Lessons42576_해시_완주하지못한선수 {

    String[] participant1 = {"leo", "kiki", "eden"};
    String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
    String[] participant3 = {"mislav", "stanko", "mislav", "ana"};

    String[] completion1 = {"kiki", "eden"};
    String[] completion2 = {"josipa", "nikola", "marina", "filipa"};
    String[] completion3 = {"stanko", "mislav", "ana"};

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        if (completion != null & completion.length > 0 & participant != null && participant.length > 0) {
            HashSet<String> completionSet = new HashSet<>();

            for (String name : completion) {
                completionSet.add(name);
            }

            for (String name : participant) {
                if (completionSet.contains(name)) {
                    completionSet.remove(name);
                } else {
                    return name;
                }
            }
        }

        return answer;
    }

    @Test
    public void test() {
        String result = this.solution(participant1, completion1);
        log.debug("result 1 : " + result);

        result = this.solution(participant2, completion2);
        log.debug("result 2 : " + result);

        result = this.solution(participant3, completion3);
        log.debug("result 3 : " + result);
    }

}
