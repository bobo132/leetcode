package com.bobo.leetcode.middle;

import com.bobo.leetcode.entity.ListNode;
import org.junit.jupiter.api.Test;

public class Page1 {

    @Test
    public void quest_2() {
        ListNode l1 = new ListNode(2, new ListNode(3, new ListNode(4)));
        ListNode l2 = new ListNode(8, new ListNode(6, new ListNode(5)));

        ListNode listNode = addTwoNumbers(l1, l2);
        ListNode.printNode(listNode);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode tail = null;

        while (l1 != null || l2 != null) {

            boolean b1 = l1 != null;
            boolean b2 = l2 != null;

            int v1 = b1 ? l1.val : 0;
            int v2 = b2 ? l2.val : 0;

            int cur = v1 + v2;
            int add = cur >= 10 ? 1 : 0;
            cur = cur >= 10 ? cur - 10 : cur;


            ListNode temp = new ListNode(cur);
            if (head == null) {
                tail = head = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            l1 = b1 && l1.next != null ? l1.next : null;
            l2 = b2 && l2.next != null ? l2.next : null;

            if (add > 0) {
                if (l1 == null) {
                    l1 = new ListNode(add);
                } else {
                    l1.val = l1.val + add;
                }
            }
        }


        // 链表反转
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
