package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * 20.09.09 완전탐색 - 소수찾기
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */
@Slf4j
public class Lessons42839_완전탐색_소수찾기 {

    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();

        permutation("", numbers, set);

        int count = 0;

        while (set.iterator().hasNext()) {
            int a = set.iterator().next();

            set.remove(a);

            if (a == 2)
                count ++;

            //2로 나누어지지 않고, 소수이면 count++
            if (a % 2 != 0 && isPrime(a)) {
                count++;
            }
        }
        return count;
    }

    // 소수인지 확인
    public boolean isPrime(int n) {
        if (n == 0 || n == 1)
            return false;

        // sqrt : n의 제곱근
        // 소수 : 자신보다 작은 두 개의 자연수를 곱하여 만들 수 없는 1보다 큰 자연수
        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    // 주어진 문자열에서 만들수 있는 모든 순열 찾기
    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();

        if (!prefix.equals(""))
            set.add(Integer.valueOf(prefix));

        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);

    }

    @Test
    public void test() {
        assertEquals(3, solution("17"));
        assertEquals(2, solution("011"));
    }

    @Test
    public void testSqrt() {
        double target = Math.sqrt(25); //25의 제곱근
        log.debug("25의 제곱근 : {}", target);
    }
}
