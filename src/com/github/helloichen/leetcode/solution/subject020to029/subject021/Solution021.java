package com.github.helloichen.leetcode.solution.subject020to029.subject021;

/**
 * 21. 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 * 两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author iChen
 * @since 2023-10-18
 */
public class Solution021 {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoLists0(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        // 搞个头
        ListNode node = new ListNode();
        // 搞个尾巴指针
        ListNode cur = node;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                // 把下一个接在尾巴后面
                cur.next = list1;
                // 处理完的要从头部去掉
                list1 = list1.next;
            } else {
                // 把下一个接在尾巴后面
                cur.next = list2;
                // 处理完的要从头部去掉
                list2 = list2.next;
            }
            // 尾巴往后移动一下
            cur = cur.next;
        }
        // 有一个为null了 把另一个接在尾巴上
        cur.next = list1 == null ? list2 : list1;
        return node.next;
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
