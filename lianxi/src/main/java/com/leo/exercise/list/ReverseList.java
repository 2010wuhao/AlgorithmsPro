package com.leo.exercise.list;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 每次都是翻转当前节点的子节点，直到子节点的next为null结束
        ListNode newHead = reverseList(head.next);
        // 最后一次递归后newHead是尾结点，是当前head的next的next，翻转操作是将它指向前一个节点
        head.next.next = head;
        head.next = null; // 必须置空防止链表指针泄露或者循环
        // newHead是返回的最终的头结点，所以每次递归返回都是newHead，并且每次递归都不能操作newHead
        return newHead;
    }

    public ListNode reverseListUseWhile(ListNode head) {
        if (head == null) {
            return head;
        }
        //添加为null的头指针，和指向当前节点的cur指针，temp用来临时存储cur的next，防止链表丢失
        //每次让cur指向pre，然后cur和pre向前移位，直到cur为null，然后返回头指针
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
