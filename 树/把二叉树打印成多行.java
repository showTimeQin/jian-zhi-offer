/*
题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

/*
 * 模仿之字形打印的算法，用null做分隔符。
 */
public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer> > lists = new ArrayList<>();
        LinkedList<TreeNode> link = new LinkedList<TreeNode>();
        TreeNode node = null;
        Iterator<TreeNode> it = null;
        
        if(pRoot == null) return lists;
          
        link.add(null);
        link.add(pRoot);
        
        while(link.size() != 1){
            node = link.removeFirst();
            if(node == null){
                ArrayList<Integer> list = new ArrayList<>();
                it = link.iterator();
                while(it.hasNext()){
                    node = (TreeNode)it.next();
                    list.add(node.val);
                }
                lists.add(list);
                link.add(null);
                continue;
            }
            
            if(node.left != null){
                link.add(node.left);
            }
            if(node.right != null){
                link.add(node.right);
            }
        }
        
        return lists;
    }
    
}