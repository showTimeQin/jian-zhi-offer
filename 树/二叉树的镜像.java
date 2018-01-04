/*
题目描述
操作给定的二叉树，将其变换为源二叉树的镜像。

输入描述:
二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
/* 
当交换完所有的非叶子结点的左右子结点之后，就得到了树的镜像 
*/

/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

/** 非递归版 */
import java.util.Stack;
 
public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null||node.right != null){
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
    }
}


/** 递归版 */
public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
         
        TreeNode pTemp = root.left;
        root.left = root.right;
        root.right = pTemp;
         
        if(root.left != null)
            Mirror(root.left);
        if(root.right != null)
            Mirror(root.right);
    }
}
