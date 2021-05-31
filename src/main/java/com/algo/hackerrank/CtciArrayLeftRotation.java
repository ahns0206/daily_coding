package com.algo.hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class CtciArrayLeftRotation {
    public static class Solution {

        /*
         * Complete the 'rotLeft' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY a
         *  2. INTEGER d
         *  //01234  4 0123
         */ //54   1 2 3 4 5 > 5 1 2 3 4 (4) -4 +
        public static List<Integer> rotLeft(List<Integer> a, int d) {
            List<Integer> result = new ArrayList<>();
            int index = a.size() % d;

            for (int i = 0; i < a.size(); i++) {
                if (i >= index) {
                    result.add(i-index, a.get(i));
                } else {
                    result.add(i-index+a.size(), a.get(i));
                }
            }

            return result;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Solution.rotLeft(a, d);

        System.out.println(result);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
