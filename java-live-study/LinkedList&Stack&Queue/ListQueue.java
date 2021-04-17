package com.company;

public class ListQueue {
    private ListNode head;

    private LinkedListImpl linkedList;

    private int front;
    private int rear;

    public ListQueue(){
        this.head = new ListNode();
        this.linkedList = new LinkedListImpl(this.head);
        this.front = 0;
        this.rear = 0;
    }

    public ListQueue(int data){
        this.head = new ListNode(data);
        this.linkedList = new LinkedListImpl(this.head);
        this.front = 0;
        this.rear = 0;
    }

    public void push(int data){
        ListNode node = new ListNode(data);
        this.linkedList.add(this.head,node,++rear);
        System.out.println(this.head.getValue());
    }

    public int pop(){
        if(front == rear){
            System.out.println("데이터 없음");
            return -1;
        }

        int result = this.head.getValue();
        this.head = this.head.getNext();
        front++;
        System.out.println(this.head.getValue());
        return result;
    }
    public int peek(){
        if(front == rear){
            System.out.println("데이터 없음");
            return -1;
        }

        int result = this.head.getValue();
        //this.head = this.head.getNext();
        return result;
    }
}
