package com.fastcampus.datastructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue는 FIFO 형태의 자료구조
 * 자바에서 Queue는 인터페이스이므로 객체 생성이 불가능하다.
 * 따라서 LinkedList를 형변환하여 조작한다.
 *
 * Queue에는 front와 rear라는 변수가 있어서, 각각 맨 앞과 맨 뒤의 인덱스를 가리키고 있다.
 */
@Slf4j
public class Queue_201203 {

    @Test
    public void test() {
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < 3; i++)
            queue.add(i);

        log.debug(String.valueOf(queue.peek())); //큐의 front가 가리키는 값을 반환한다.
        log.debug(String.valueOf(queue.poll())); //큐의 front가 가리키는 값을 반환하고 삭제한다.
        log.debug(String.valueOf(queue.isEmpty())); // false
        log.debug(String.valueOf(queue));
    }
}
