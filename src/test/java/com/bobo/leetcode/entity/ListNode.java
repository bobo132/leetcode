package com.bobo.leetcode.entity;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    
    public static void printNode(ListNode node) {
        StringBuilder sb = new StringBuilder(node.val + "");
        while (node.next != null) {
            sb.append("->").append(node.next.val);
            node = node.next;
        }
        System.out.println(sb);
    }

    
    
    /**
     * 尾插法, 创建链表
     * 
     * @param arr 数组
     * @return 头结点
     */
    public static ListNode createLinkByTail(int... arr) {

        ListNode head = null;
        ListNode tail = null;

        for (int x : arr) {
            ListNode p = new ListNode(x);
            if (head == null) {
                tail = head = p;
            } else {
                tail.next = p;
                tail = p;
            }
        }
        return head;
    }


     /**
     * 头插法, 创建链表
     * 
     * @param arr 数组
     * @return 头结点
     */
    public static ListNode createLinkByHead(int... arr) {

        ListNode head = null;

        for (int x : arr) {
            ListNode p = new ListNode(x);
            if (head != null) {
                p.next = head;
            }
            head = p;
        }
        return head;
    }

    /**
     * 反转链表
     */
    public static ListNode reverseLink(ListNode head) {
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


    /**
     * 反转链表2
     */
    public static ListNode reverseLink2(ListNode head) {
        ListNode next = null;
        ListNode pre = null;

        while (head != null) {
            next = head.next;   // 将head.next赋值给next变量, 也就是说next指向了节点2, 现将节点2保存起来 
            head.next = pre;    // 将pre变量赋值给了head.next, 即节点1指向了null
            pre = head;         // 将head赋值给了pre, 即pre指向节点1, 将节点1设置为"上一个节点".
            head = next;        // 将next赋值给了head, 即head指向了节点2, 将节点2设置为"头结点"
        }
        return pre;
    }


    
}
