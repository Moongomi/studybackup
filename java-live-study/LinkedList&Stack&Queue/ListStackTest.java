package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListStackTest {

    @Test
    void stackTest(){
        ListStack listStack = new ListStack(0);

        listStack.push(1);
        listStack.push(4);

        assertEquals(4,listStack.pop());
    }


}