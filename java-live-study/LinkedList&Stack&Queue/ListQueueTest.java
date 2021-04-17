package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListQueueTest {

    @Test
    void queueTest(){
        ListQueue listQueue = new ListQueue(0);

        listQueue.push(1);
        listQueue.push(4);

        assertEquals(0,listQueue.pop());

        listQueue.push(3);

        assertEquals(1,listQueue.pop());

    }

}