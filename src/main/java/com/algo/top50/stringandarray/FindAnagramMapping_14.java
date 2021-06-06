package com.algo.top50.stringandarray;

import java.util.HashMap;

public class FindAnagramMapping_14 {

    public static void main(String[] args) {
        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};
        int[] result = anagramMappings(A, B); //{1, 4, 3, 2, 0}
        print(result);
    }

    public static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] anagramMappings(int[] A, int[] B) {
        int len = A.length;
        int[] res = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i< len; i++) {
            map.put(B[i], i); //120, 281
        }
        for (int i = 0; i < len; i++) {
            res[i] = map.get(A[i]);
        }

        return res;
    }

    public static int[] anagramMappings2(int[] A, int[] B) {
        int len = A.length;
        int[] res = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map.put(B[i], i);
        }
        for (int i = 0; i < len; i++) {
            res[i] = map.get(A[i]);
        }
        return res;
    }
}