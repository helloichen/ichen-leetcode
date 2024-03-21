package com.github.helloichen.leetcode.solution.subject020to029;

import java.util.Stack;

/**
 * 25 K 个一组翻转链表
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 * @author iChen
 * @since 2024-03-19
 */
public class Solution025 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reverseKGroup0(l1, 3);
    }

    /**
     * 使用栈先进后出的特征来做反转
     */
    public static ListNode reverseKGroup0(ListNode head, int k) {
        ListNode result = new ListNode();
        ListNode cur = result;
        Stack<ListNode> stack = new Stack<>();
        ListNode tail = null;
        out:
        while (head != null) {
            ListNode temp = head;
            for (int i = 0; i < k; i++) {
                stack.push(head);
                if (head.next == null) {
                    tail = temp;
                    break out;
                }
                head = head.next;
            }

            while (!stack.isEmpty()) {
                cur.next = stack.pop();
                cur = cur.next;
            }
        }
        if (tail != null) {
            cur.next = tail;
        }
        return result.next;
    }


    private static class ListNode {
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
    }

}
