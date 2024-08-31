package com.learrn.leetcode;

/**
 * 19. Remove Nth Node From End of List
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = init(new int[]{1, 2, 3 ,4, 5});
        int n = 3;
        System.out.println(removeNthFromEnd(head, n));
        head = init(new int[]{1, 2, 3 ,4, 5});
        System.out.println(removeNthFromEnd2(head, n));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0, b = 0;
        ListNode nodeA = head, nodeB = head;
        while (nodeA != null) {
            nodeA = nodeA.next;
            size++;
            if (nodeA != null && size - b == n + 1) {
                nodeB = nodeB.next;
                b++;
            }
        }
        if (size == 1 && n == 1) {
            head = null;
        } else if (b != 0 || size - b - 1 == n) {
            nodeB.next = nodeB.next.next;
        } else if (size - b == n) {
            head = head.next;
        }
        System.out.println(nodeA);
        System.out.println(b);
        System.out.println(nodeB);
        System.out.println(head);
        return head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }


    static ListNode init(int[] ns) {
        ListNode head = new ListNode(ns[0], null);
        if (ns.length > 1) {
            head.next = new ListNode();
            ListNode t = head.next;
            for (int i = 1; i < ns.length; i++) {
                t.val = ns[i];
                if (i < ns.length - 1) {
                    t.next = new ListNode();
                    t = t.next;
                }
            }
        }

        return head;
    }

}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}