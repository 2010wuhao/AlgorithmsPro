package com.leo.exercise.list;

public class MergeTwoSortLinklist {

    public static ListNode mergeUseTraversal(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0);//创建头结点
        ListNode lianjie = header;//通过这个链接走一圈把两个链表连接起来
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                lianjie.next = l1;
                l1 = l1.next;//移动链表1的指针指向待排序的链表
            } else {
                lianjie.next = l2;
                l2 = l2.next;
            }
            lianjie = lianjie.next;//这一步把两个链表排序后链接起来
        }
        //把连接指向非空的链表头指针
        lianjie.next = l1 != null ? l1 : l2;
        return header.next;
    }

    public static ListNode mergeUseRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.value <= l2.value) {
            l1.next = mergeUseRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeUseRecursion(l1, l2.next);
            return l2;
        }
    }
}
