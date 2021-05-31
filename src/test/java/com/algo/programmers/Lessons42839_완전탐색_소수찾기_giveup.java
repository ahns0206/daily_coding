package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * 20.09.09 완전탐색 - 소수찾기
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 * <p>
 * 소수 : 자신보다 작은 두 개의 자연수를 곱하여 만들 수 없는 1보다 큰 자연수
 * Brute-Forces는 대표적으로 순열, 조합, 재귀함수, 비트마스크 사용해서 풀수 있음
 * 순열 : 서로 다른 n개의 원소에서 r개를 중복을 허용하지 않고 선택하여 순서대로 늘어 놓은 것, O(N!)
 * 재귀함수 : 함수 내에서 자기 자신을 다시 호출하는 함수
 * 더 이상 쪼개지지 않는 가장 작은 작업, 즉 최소한의 작업에 도달시 결과값을 반환하는 조건문이 있어야 함
 */
@Slf4j
public class Lessons42839_완전탐색_소수찾기_giveup {
    List<Integer> numberList = new ArrayList<>();

    //주어진 문자열에서 만들수 있는 모든 순열 찾기
    public void getPermutationList(String s, String number) {
        if (number.length() == 0) {
            if (!s.equals("")) //첫 숫자는 제외
                numberList.add(Integer.parseInt(s));
        } else {
            for (int i = 0; i < number.length(); i++)
                getPermutationList(s + number.charAt(i), number.substring(0, i) + number.substring(i + 1, number.length()));
            for (int i = 0; i < number.length(); i++)
                getPermutationList(s, number.substring(0, i) + number.substring(i + 1, number.length()));
        }
    }

    //소수인지 확인
    public boolean isPrime(int number) {
        Boolean isPrime = false;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = true;
                break;
            }
        }

        return isPrime;
    }

    public int solution(String numbers) {
        int answer = 0;

        getPermutationList("", numbers);

        //중복 제거
        this.numberList = numberList.stream().distinct().collect(Collectors.toList());

        for (Integer integer : numberList) {
            if (isPrime(integer))
                answer++;
        }

        return answer;
    }

    @Test
    public void test() {
        assertEquals(3, solution("17"));
        assertEquals(2, solution("011"));
    }

    @Test
    public void primeTest() {
        assertEquals(true, isPrime(7));
        assertEquals(true, isPrime(214867));

        assertEquals(false, isPrime(10));
    }
}
