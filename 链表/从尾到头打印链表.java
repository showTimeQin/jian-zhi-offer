/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
/**
 * @question 输入一个链表，从尾到头打印链表每个节点的值。
 * @answer 借助递归实现（递归的本质还是使用了堆栈结构）
 */
import java.util.ArrayList;
public class Solution {
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
 	   if(listNode!=null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}


/**
 * @answer 借助堆栈的“后进先出”实现
 */
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack=new Stack<Integer>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;     
        }
        
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}

/**
 * @answer 利用arraylist的add(int index, E element)方法
 */
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        while(listNode!=null){
            arr.add(0,listNode.val);
            listNode=listNode.next;
        }
        return arr;
    }
}