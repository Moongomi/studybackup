package com.company;

public class ListStack {
    private ListNode head;

    private LinkedListImpl linkedList;

    public ListStack(int data){
        this.head = new ListNode(data);
        this.linkedList = new LinkedListImpl(this.head);
    }

    public void push(int data){
        ListNode node = new ListNode(data);
        this.linkedList.add(node,this.head,1);
        this.head = node;
    }

    public int pop(){
        int result = this.head.getValue();
        this.head = this.head.getNext();
        return result;
    }

}
