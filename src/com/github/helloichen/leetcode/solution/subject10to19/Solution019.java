package com.github.helloichen.leetcode.solution.subject10to19;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * @author iChen
 * @since 2023-10-18
 */
public class Solution019 {


    public static void main(String[] args) {

    }

    /**
     * 快慢指针
     * 定义两个指针 fast 和 slow，初始时都指向链表的虚拟头结点 dummy。
     *
     * 接着 fast 指针先向前移动 n
     * 步，然后 fast 和 slow 指针同时向前移动，直到 fast 指针到达链表的末尾。此时 slow.next 指针指向的结点就是倒数第 n 个结点的前驱结点，将其删除即可。
     *
     * 时间复杂度 O(n)
     * ，空间复杂度 O(1)
     * 。其中 n
     * 为链表的长度
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        // 快指针先移动n个位置
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        // 快慢指针同时移动，快指针到达末尾时慢指针的下一个就是要处理的节点
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 慢指针的下一个指向下下个
        slow.next = slow.next.next;
        return dummy.next;
    }

    static class ListNode {
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




