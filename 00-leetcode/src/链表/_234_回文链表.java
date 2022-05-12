package 链表;

import java.util.ArrayList;

public class _234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> vals = new ArrayList<>();

        //把node的数值复制到vals里面
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        //使用双指针
        int front = 0, back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
