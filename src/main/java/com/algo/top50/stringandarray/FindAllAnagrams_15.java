package com.algo.top50.stringandarray;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams_15 {

    public static void main(String args[]) {
        FindAllAnagrams_15 a = new FindAllAnagrams_15();
        String txt = "BACDGABCDA";
        String pat = "ABCD"; //65, 66, 67, 68
        System.out.println(a.findAnagrams(txt, pat)); //[0, 5, 6]
    }


    public List<Integer> findAnagrams(String txt, String pat) {
        //1
        List<Integer> result = new ArrayList<>();

        if (txt == null || txt.length() == 0
                || pat == null || pat.length() == 0
                || txt.length() < pat.length())
            return result;

        //2
        int[] patArr = new int[256]; //아스키는 영어 대문자 65-90, 영어 소문자 97-122

        for (int i = 0; i < pat.length(); i++) {
            patArr[pat.charAt(i)]++;
        }
        //[0,0,0,0,0,0,1,1,1,1,0,0,0]

        for (int i = 0; i < txt.length() - pat.length() + 1; i++) {
            int[] txtArr = new int[256];

            for (int j = 0; j < pat.length(); j++) {
                txtArr[txt.charAt(i + j)]++;
            }

            if (check(patArr, txtArr)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean check(int[] patArr, int[] txtArr) {
        for (int i = 0; i < patArr.length; i++) {
            if (patArr[i] != txtArr[i]) {
                return false;
            }
        }
        return true;
    }


}
