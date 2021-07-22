package com.bobo.leetcode.simple;

import com.bobo.leetcode.entity.ListNode;
import org.junit.jupiter.api.Test;

public class Page5 {

    @Test
    public void f1() {

        ListNode l1 = new ListNode(2, new ListNode(3, new ListNode(4)));
        l1 = reverseList(l1);
        ListNode.printNode(l1);

        ListNode l2 = ListNode.createLinkByTail(1, 2, 3, 4, 5);
        ListNode.printNode(l2);

        ListNode l3 = ListNode.createLinkByHead(1, 2, 3, 4, 5);
        ListNode.printNode(l3);

    }


    public ListNode reverseList(ListNode head) {

        ListNode p = head;
        head = null;

        while (p != null) {
            ListNode q = p.next;
            p.next = head;
            head = p;
            p = q;
        }
        return head;
    }


}
