package com.company;

public class ArrayQueue {
    private int[] datas;
    private int size;
    private int front;
    private int rear;

    public ArrayQueue(int size){
        this.front = 0;
        this.rear = 0;
        this.size = size;
        this.datas = new int[size];
    }

    public boolean isFull(){
        if(rear > size-1){
            return true;
        }
        else{
            return false;
        }
    }

    public void push(int data){
        if(isFull()){
            System.out.println("용량 초과");
            return;
        }
        this.datas[this.rear++] = data;
    }

    public int pop(){
        if(front == rear){
            System.out.println("데이터 없음");
            return -1;
        }
        return datas[front++];
    }

    public int peek(){
        if(front == rear){
            System.out.println("데이터 없음");
            return -1;
        }
        return datas[front];
    }
}
