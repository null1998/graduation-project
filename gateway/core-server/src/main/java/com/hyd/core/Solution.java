package com.hyd.core;

import java.util.*;


 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class Solution {
    public static void main(String[] args) {
        int[] array = new int[]{10,40,20,30};
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i : array) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode next = dummy.next;
        dummy.next = null;
        new Solution().reorderList(next);
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            if (fast != null && fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        ListNode newHead = reverse(secondHead);
        while (newHead != null) {
            ListNode tmp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = tmp;
        }
    }
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }
}
