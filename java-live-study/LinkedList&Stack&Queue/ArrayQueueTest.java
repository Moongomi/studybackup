package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {
    @Test
    void ArrayQueueTest() {
        ArrayQueue arrayQueue = new ArrayQueue(5);

        for(int i =0;i<5;i++){
            arrayQueue.push(i);
        }

        assertEquals(0,arrayQueue.pop());
        assertEquals(1,arrayQueue.pop());
        assertEquals(2,arrayQueue.peek());
        assertEquals(2,arrayQueue.peek());

        arrayQueue.push(10);
        //용량 초과
    }
}