/*
题目描述
输入一个链表，输出该链表中倒数第k个结点。
*/

/*
两个指针一起跑，一个在前，一个距离k在后。前面的跑到尽头，返回后面的指针。
 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {

	ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k)
                q = q.next;
            p = p.next;
        }
        return i < k ? null : q;
    }
}