/*
题目描述
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
*/

//这是一种求树的深度的魔改版题目
public class Solution {
	public boolean IsBalanced_Solution(TreeNode root) {
        return (f(root) == -1) ? false : true;
    }
 
    private int f(TreeNode root) {
        if (root == null) {
            return 0;
        }
 
        int left = f(root.left);
        int right = f(root.right);
 
        if ((left != -1) && (right != -1)) {
            if (left - right > 1 || right - left > 1){
                return -1;
            }
             return (left > right ? left : right) + 1;
        }
        return -1;
    }
}