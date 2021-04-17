package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    void ArrayStackTest() {
        ArrayStack arrayStack = new ArrayStack(5);

        for(int i =0;i<5;i++){
            arrayStack.push(i);
        }

        assertEquals(4,arrayStack.pop());
    }

}