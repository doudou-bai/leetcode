package 剑指OfferII;

public class _024_反转链表 {
    public ListNode reverseList(ListNode head) {
        //定义一个临时的变量进行存储
        ListNode prev = null;
        //把头结点赋值给curr
        ListNode curr = head;
        //遍历
        while (curr != null) {
            System.out.println(curr);
            //  第二个节点
            ListNode next = curr.next;
            //赋值给临时变量
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

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
    }
}
