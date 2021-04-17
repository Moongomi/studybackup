package com.company;

public class ArrayStack {
    private int[] datas;
    private int size;
    private int pointer;

    public ArrayStack(int size){
        this.pointer = 0;
        this.size = size;
        this.datas = new int[size];
    }

    public void push(int data){
        if(pointer>=size){
            System.out.println("용량 초과");
            return;
        }
        this.datas[this.pointer++] = data;
    }

    public int pop(){
        return datas[--pointer];
    }

}
