package com.company;


import static org.junit.jupiter.api.Assertions.*;

class LinkedListImplTest {

    @org.junit.jupiter.api.Test
    void testall() {
        ListNode head = new ListNode(1);

        LinkedListImpl linkedList = new LinkedListImpl(head);

        linkedList.add(head,new ListNode(2),1);
        linkedList.add(head,new ListNode(8),1);

        linkedList.remove(head,1);

        assertTrue(linkedList.contains(head,new ListNode(1)));
        assertFalse(linkedList.contains(head,new ListNode(8)));
        assertTrue(linkedList.contains(head,new ListNode(2)));

        linkedList.printList(head);
    }


}