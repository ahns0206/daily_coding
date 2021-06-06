package com.algo.top50.stringandarray;

import java.util.*;

/* 문제 접근 방법
 * 1. Map 이용
 * 2. Anagrams -> sorting 후 Map에 key-value로 담기*/
public class GroupAnagrams_17 {

    public static void main(String[] args) {

        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"}; //무조건 소문자임을 가정
        System.out.println(groupAnagrams(list));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
        	return new ArrayList<List<String>>();

        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str : strs) {
            //1. sorting
            char[] ca = str.toCharArray();
            Arrays.sort(ca);

            //2. key 만들기
            String keyStr = String.valueOf(ca);

            //3. map에 넣기
            if (map.containsKey(keyStr)) {
				map.get(keyStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(keyStr, list);
            }

        }

        return new ArrayList<List<String>>(map.values());
    }
}
