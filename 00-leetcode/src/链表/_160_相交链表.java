package 链表;

import java.util.HashSet;
import java.util.Set;

public class _160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //创建一个set集合进行存储
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
