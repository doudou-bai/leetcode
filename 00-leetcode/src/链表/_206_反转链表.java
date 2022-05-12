package 链表;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class _206_反转链表 {
    public class ListNode {
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

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode listNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return listNode;
        }

        public ListNode reverseList2(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode newHead = null;
            while (head != null) {
                ListNode tmp= head.next;
                newHead = head.next;
                head = tmp;
            }
            return newHead;

        }

    }


}
