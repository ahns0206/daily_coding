package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * 20.08.01 해시 - 전화번호 목록
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
@Slf4j
public class Lessons42577_해시_전화번호목록 {
    private final String[] phone_book_1 = {"119", "97674223", "1195524421"};
    private final String[] phone_book_2 = {"123", "456", "789"};
    private final String[] phone_book_3 = {"12", "123", "1235", "567", "88"};

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Boolean> map = new HashMap<>();

        for (String phoneNumber : phone_book) {
            map.put(phoneNumber, false);
            for (String otherPhoneNumber : phone_book) {
                if (!phoneNumber.equals(otherPhoneNumber)
                        && otherPhoneNumber.startsWith(phoneNumber)) {
                    map.put(phoneNumber, true);
                    break;
                }
            }

            if (map.containsValue(true)) {
                answer = false;
                break;
            }
        }

        return answer;
    }

    @Test
    public void test() {
        assertEquals(false, solution(phone_book_1));

        assertEquals(true, solution(phone_book_2));

        assertEquals(false, solution(phone_book_3));
    }

    @Test
    @Ignore
    public void test2() {
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("1", true);
        map.put("1", false);
        map.put("1", true);
    }
}
