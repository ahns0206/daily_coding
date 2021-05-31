package com.algo.programmers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 20.08.14 최소힙 - 더 맵게
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */
@Slf4j
public class Lessons42626_힙_더맵게_giveup {

    static final int[] scovile1 = {1, 2, 3, 9, 10, 12};
    int[] minHeap = new int[1000000];
    int heapSize = 0;

    public void swap(int i, int j) {
        int temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;
    }

    public void insertMinHeap(int K) {
        minHeap[++heapSize] = K; //마지막 노드에 insert

        for (int i = heapSize; i > 1; i /= 2) {
            //부모노드보다 마지막 노드가 작으면 swap
            if (minHeap[i / 2] > minHeap[i]) {
                swap(i / 2, i);
            }
        }
    }

    //최소힙에서 삭제연산은 최솟값을 가진 요소를 삭제하는 것임
    public int deleteMinHeap() {
        if (heapSize == 0) // 배열이 빈 경우
            return -1;

        int item = minHeap[1]; // 루트 노드의 값을 저장한다.
        minHeap[1] = minHeap[heapSize]; // 마지막 노드의 값을 루트 노드에 둔다.
        minHeap[heapSize--] = 0; // 힙 크기를 하나 줄이고 마지막 노드를 0으로 초기화한다.

        for (int i = 1; i * 2 <= heapSize; ) {
            if ((heapSize <= i * 2 || minHeap[i] < minHeap[i * 2])
                    && (heapSize <= i * 2 + 1 || minHeap[i] < minHeap[i * 2 + 1])) {
                // 마지막 노드가 왼쪽 노드와 오른쪽 노드보다 작으면 반복문을 나간다.
                break;
            } else if (heapSize >= i * 2 && minHeap[i * 2] < minHeap[i * 2 + 1]) {
                // 왼쪽 노드가 더 작은 경우
                // 왼쪽 노드와 마지막 노드를 swap하고 왼쪽으로 이동
                swap(i, i * 2);
                i = i * 2;
            } else if (heapSize >= i * 2 + 1 && minHeap[i * 2] > minHeap[i * 2 + 1]) {
                // 오른쪽 노드가 더 작은 경우
                // 오른쪽 노드와 마지막 노드를 swap하고 오른쪽으로 이동
                swap(i, i * 2 + 1);
                i = i * 2 + 1;
            }
        }

        return item;
    }

    public int calculateScovile(int K) {
        int newScovile = 0;
        int deleteMinResult = 0;

        deleteMinResult = deleteMinHeap();
        if (deleteMinResult != -1)
            newScovile += deleteMinResult;
        else
            return -1;

        deleteMinResult = deleteMinHeap();
        if (deleteMinResult != -1)
            newScovile += deleteMinResult * 2;
        else
            return -1;

        insertMinHeap(newScovile);

        return deleteMinResult;
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        //최소힙에 K insert
        for (int i : scoville) {
            insertMinHeap(i);
        }

        //최소힙 root 노드값이 K보다 작으면 섞기
        while (minHeap[1] < K) {
            int result = calculateScovile(K);

            if (result == -1)
                return -1;

            answer++;
        }

        return answer;
    }

    @Test
    public void test() {
        assertEquals(2, solution(scovile1, 7));
    }
}
