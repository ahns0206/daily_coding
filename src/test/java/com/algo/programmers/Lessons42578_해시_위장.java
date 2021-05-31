package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

/**
 * 20.08.01
 */
@Slf4j
public class Lessons42578_해시_위장 {

    public int solution(String[][] clothes) {
        int answer = 0;
        LinkedHashMap<String, String[]> clothesMap = new LinkedHashMap<String, String[]>();
        String[] temp = new String[30];


        for (int i = 0; i < clothes.length; i++) {
            if (clothesMap.containsKey(clothes[i][1])) {
                temp = (String[]) clothesMap.get(clothes[i][1]);
                temp[temp.length] += clothes[i][0];
                clothesMap.replace(clothes[i][1], temp);
            } else {
                clothesMap.put(clothes[i][1], new String[]{clothes[i][0]});
            }
        }

//        while (keySetSize != 0)
//            key 안에서 keySetSize 만큼 조합으로 key들 뽑고
//            뽑은 key들 리스트를 for로 돌면서 value size 서로 곱해서 더한다음에 answer에 합치기
//            keySetSize--;

        for (int i = 1; i <= clothesMap.keySet().size(); i++) {
            for (HashMap.Entry<String, String[]> entry : clothesMap.entrySet()) {


            }
        }

        return answer;
    }

    @Test
    public void test() {
        assertEquals(5, solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
//        assertEquals(3, solution(new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}
