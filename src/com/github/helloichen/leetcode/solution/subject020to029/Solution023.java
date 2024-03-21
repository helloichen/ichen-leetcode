package com.github.helloichen.leetcode.solution.subject020to029;

import java.util.PriorityQueue;

/**
 * 23. 合并 K 个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表
 * @author iChen
 * @since 2024-03-19
 */
public class Solution023 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = new ListNode[] { l1, l2, l3 };
        ListNode listNode = mergeKLists0(lists);
        System.out.println(l1);
    }

    private static ListNode mergeKLists0(ListNode[] lists) {
        // 搞一个优先队列
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        // 把每个链表的head放在队列里面
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }
        // 每次从队列中poll一个出来，取出来的的next在offer进去
        // 结果 head
        ListNode result = new ListNode();
        // 尾巴 用来保存结果中的当前node的值，每次把取出来的node的保存在cur中
        ListNode cur = result;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.offer(node.next);
            }
            // 把下一个放在尾巴后面
            cur.next = node;
            // 尾巴位置移动一下
            cur = cur.next;
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




