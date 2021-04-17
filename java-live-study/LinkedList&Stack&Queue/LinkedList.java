package com.company;

public interface LinkedList {
    public ListNode add(ListNode head, ListNode nodeToAdd, int position);

    public ListNode remove(ListNode head, int positionToRemove);

    boolean contains(ListNode head, ListNode nodeTocheck);
}
