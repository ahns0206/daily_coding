package com.hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 20.08.01
 */
@Slf4j
public class RotLeft {

    public List<Integer> solution(List<Integer> a, int d) {
        List<Integer> result = a;
        d = d%a.size();

        for (int i = d; i < a.size(); i++) {
            result.set(i - d, a.get(i));
        }

        for (int j = 0; j < d; j++) {
            result.set(a.size() - d + j, a.get(j));
        }
        log.debug(result.toString());

        return result;
    }

    @Test
    public void test() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        solution(a, 54);
    }
}
