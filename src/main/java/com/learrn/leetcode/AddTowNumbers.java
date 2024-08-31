package com.learrn.leetcode;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTowNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        AddTowNumbers addTwoNumbers = new AddTowNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int t = 0;
        ListNode first = null;
        ListNode last = null;
        while(l1!=null || l2!=null) {
            int sum = (l1!=null ? l1.val : 0) + (l2!=null ? l2.val : 0) + t;
            if(sum >= 10) {
                t = 1;
            } else {
                t = 0;
            }
            if(first == null) {
                first = new ListNode(sum%10);
                last = first;
                l1 = l1==null ? null : l1.next;
                l2 = l2==null ? null : l2.next;
                continue;
            }

            last.next = new ListNode(sum % 10);
            last = last.next;
            l1 = l1==null ? null : l1.next;
            l2 = l2==null ? null : l2.next;
        }

        if(t == 1) {
            last.next = new ListNode(t);
        }
        return first;
    }
}
