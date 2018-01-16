/*
题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
*/

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
import java.util.*;
public class Solution {

public static ListNode deleteDuplication(ListNode pHead) {
        //指向头，因为有可能一开始的头结点是重复的
        ListNode first = new ListNode(-1);//设置一个trick
 
        first.next = pHead;
 		//指向下一个节点
        ListNode p = pHead;
    	//指向下一个不重复的节点
        ListNode last = first;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p!= null&&p.val == val)
                    p = p.next;
                last.next = p;
            } else {
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }
    
    
}