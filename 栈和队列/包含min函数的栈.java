/*
题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
*/

/*
思路：用一个数组保存数据，用另外一个栈minStack保存依次入栈最小的数
比如，数组中依次入栈，5,  4,  3, 8, 10, 11, 12, 1
       则minStack依次入栈，5,  4,  3，no,no, no, no, 1
 
no代表此次不如栈
每次入栈的时候，如果入栈的元素比min中的栈顶元素小或等于则入栈，否则不如栈。
*/
import java.util.Stack;
import java.util.Arrays;
public class Solution {
/*借用辅助栈存储min的大小，自定义了栈结构
*/
    private int size;
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> minStack = new Stack<Integer>();
    private Integer[] elements = new Integer[10];
    public void push(int node) {
        ensureCapacity(size+1);
        elements[size++] = node;
        if(node <= min){
            minStack.push(node);
            min = node;
        }else{
            minStack.push(min);
        }
    }
 
    private void ensureCapacity(int size) {
        int len = elements.length;
        if(size > len){
            int newLen = (len*3)/2+1; //每次扩容方式
            elements = Arrays.copyOf(elements, newLen);
        }
    }
    public void pop() {
        Integer top = top();
        if(top != null){
            elements[size-1] = (Integer) null;
        }
        size--;
        minStack.pop();    
        min = minStack.peek();
    }
 
    public int top() {
        if(!empty()){
            if(size-1>=0)
                return elements[size-1];
        }
        return (Integer) null;
    }
    public boolean empty(){
        return size == 0;
    }
 
    public int min() {
        return min;
    }
}