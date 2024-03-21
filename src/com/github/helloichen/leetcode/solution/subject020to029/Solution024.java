package com.github.helloichen.leetcode.solution.subject020to029;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * @author iChen
 * @since 2024-03-19
 */
public class Solution024 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = swapPairs0(l1);
    }

    /**
     * 交换之前的节点关系是 temp -> node1 -> node2 -> x，
     * 交换之后的节点关系要变成 temp -> node2 -> node1 -> x，因此需要进行如下操作
     *
     * 也可以通过迭代的方式实现两两交换链表中的节点。
     *
     * 创建哑结点 dummyHead，令 dummyHead.next = head。令 temp 表示当前到达的节点，初始时 temp = dummyHead。每次需要交换 temp 后面的两个节点。
     *
     * 如果 temp 的后面没有节点或者只有一个节点，则没有更多的节点需要交换，因此结束交换。否则，获得 temp 后面的两个节点 node1 和 node2，通过更新节点的指针关系实现两两交换节点。
     *
     * 具体而言，交换之前的节点关系是 temp -> node1 -> node2，交换之后的节点关系要变成 temp -> node2 -> node1，因此需要进行如下操作。
     *
     * temp.next = node2
     * node1.next = node2.next
     * node2.next = node1
     * 完成上述操作之后，节点关系即变成 temp -> node2 -> node1。再令 temp = node1，对链表中的其余节点进行两两交换，直到全部节点都被两两交换。
     *
     * 两两交换链表中的节点之后，新的链表的头节点是 dummyHead.next，返回新的链表的头节点即可
     */
    public static ListNode swapPairs1(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            // temp -> node2
            temp.next = node2;
            // node2后面到x接到node1后面去
            node1.next = node2.next;
            // node2 -> node1
            node2.next = node1;
            // temp 记录一下链表遍历到哪里了
            // node1后面到已经变化了
            temp = node1;
        }
        return dummyHead.next;
    }

    public static ListNode swapPairs0(ListNode head) {
        ListNode result = new ListNode();
        ListNode resultCurIdx = result;
        if (head == null) {
            return result.next;
        }
        // 只有一个节点
        if (head.next == null) {
            resultCurIdx.next = head;
            return result.next;
        }
        while (head.next != null) {
            ListNode t1 = new ListNode(head.val);
            ListNode t2 = new ListNode(head.next.val);
            resultCurIdx.next = t2;
            resultCurIdx.next.next = t1;
            resultCurIdx = resultCurIdx.next.next;
            if (head.next.next == null) {
                break;
            }
            if (head.next.next.next == null) {
                resultCurIdx.next = head.next.next;
                break;
            }
            head = head.next.next;
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
