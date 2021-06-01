package com.algo.top50.stringandarray;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones_07 {

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        System.out.println(solve(J, S));
    }

    public static int solve(String J, String S) {
    	int result = 0;
    	Set<Character> jSet = new HashSet<>();
		for(Character jc : J.toCharArray()) {
			jSet.add(jc);
		}

		for(Character sc : S.toCharArray()) {
			if (jSet.contains(sc))
				result++;
		}

    	return result;
	}

}
