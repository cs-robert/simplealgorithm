package com.algorithm.list;

public class ReverseList {

    public static void main(String args[]) {
        MyLinkedList.Node<Integer> head = new MyLinkedList.Node(1);
        head.next = new MyLinkedList.Node(2);
        head.next.next = new MyLinkedList.Node(3);

        MyLinkedList.Node node = reverse3(head);
        for (; node != null; node = node.next) {
            System.out.println(node.ele);
        }
    }

    public static MyLinkedList.Node reverse(MyLinkedList.Node head) {
        MyLinkedList.Node pre = null;
        MyLinkedList.Node cur = head;
        MyLinkedList.Node next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static MyLinkedList.Node reverse2(MyLinkedList.Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        MyLinkedList.Node newHead = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static MyLinkedList.Node reverse3(MyLinkedList.Node head) {
        MyLinkedList.Node newHead = null;
        while (head != null) {
            MyLinkedList.Node   next = head.next;
            head.next=newHead;
            newHead=head;
            head = next;
        }
        return newHead;
    }
}
