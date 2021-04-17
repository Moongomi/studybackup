package com.company;

public class LinkedListImpl implements LinkedList {

    private final ListNode listNode;

    public LinkedListImpl(ListNode listNode) {
        this.listNode = listNode;
    }

    @Override
    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        if(position<0){
            return null;
        }

        ListNode target = head;
        ListNode addNode = nodeToAdd;

        for(int i =0; i < position-1; i++){
            target = target.getNext();
            if(target == null){
                return head;
            }
        }

        while(addNode.getNext()!=null){
            addNode = addNode.getNext();
        }

        addNode.setNext(target.getNext());
        target.setNext(nodeToAdd);
        return head;
    }

    @Override
    public ListNode remove(ListNode head, int positionToRemove) {
        ListNode target = head;

        for(int i = 0; i < positionToRemove-1;i++){
            target = target.getNext();

            if(target == null){
                return head;
            }
        }

        ListNode removeNode = target.getNext();

        if(removeNode != null){
            target.setNext(removeNode.getNext());
        }

        return head;
    }

    @Override
    public boolean contains(ListNode head, ListNode nodeTocheck) {
        if(head == null){
            return false;
        }

        ListNode target = head;

        while(target!=null){
            System.out.println(target.getValue());
            if(target.getValue() == nodeTocheck.getValue())return true;
            target = target.getNext();
        }
        return false;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.getValue());
            head = head.getNext();
        }
    }

}
