package 链表;

import com.sun.org.apache.xerces.internal.impl.dv.xs.AnyURIDV;

public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
