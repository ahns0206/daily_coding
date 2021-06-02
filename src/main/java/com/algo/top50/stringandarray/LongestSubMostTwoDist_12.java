package com.algo.top50.stringandarray;

import java.util.HashMap;
import java.util.Map;

/*
1. end-start 로 비교한 값을 length에 담는다.
2. 문자를 2개 인식하기 위해 counter라는 문자 갯수를 map에 담는다.*/
public class LongestSubMostTwoDist_12 {

    public static void main(String[] args) {
        String s = "ccaabbb";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0, end = 0, counter = 0, len = 0;
        Map<Character, Integer> map = new HashMap<>(); //문자의 갯수 관리 c=2, a=2, b=3

        while (end < s.length()) {
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            if (map.get(endChar) == 1) counter++;//new char
            end++;

            while (counter > 2) {
                char cTemp = s.charAt(start);

                map.put(cTemp, map.get(cTemp) - 1);

                if (map.get(cTemp) == 0) {
                    counter--;
                }
                start++;
            }

            len = Math.max(len, end-start);
        }

        return len;
    }

}
