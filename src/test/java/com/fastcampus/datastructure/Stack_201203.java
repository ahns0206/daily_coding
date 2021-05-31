package com.fastcampus.datastructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Stack;

/**
 * Stack은 LIFO 형태의 자료구조
 * Collection이 모든 객체를 저장할 수 있기 때문에,
 * Generics이라는 조건을 주어 저장할 수 있는 타입을 지정할 수 있다.
 * <String> 이 부분임
 *
 * Stack은 top이라는 변수만을 저장하며, 가장 꼭대기의 위치가 어디인지를 저장하고 있다.
 */
@Slf4j
public class Stack_201203 {

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<Integer>(); //Generics을 이용하여 Collection이 저장할 데이터 타입 지정
        for (int i = 0; i < 3; i++)
            stack.push(i);

        log.debug(String.valueOf(stack.peek())); //스택의 꼭대기 값을 반환한다.
        log.debug(String.valueOf(stack.pop())); //스택의 꼭대기 값을 반환하고 삭제한다.
        log.debug(String.valueOf(stack.search(2))); //값이 존재하면 1, 아니면 -1을 출력한다.
        log.debug(String.valueOf(stack.isEmpty())); //스택이 비어있으면 true을 출력한다.
        log.debug(String.valueOf(stack));

    }
}
