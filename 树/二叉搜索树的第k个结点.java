/*
题目描述
给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
*/

//按中序遍历
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
public class Solution {
    private int count;	//计数器
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        count = k;
        return KNode(pRoot); 
    }

	private TreeNode KNode(TreeNode pRoot){
        if(pRoot == null) return null;
        
        TreeNode node = KNode(pRoot.left);
        if(node != null) return node;
        
        if(count == 1) return pRoot;
        --count;
        
        return KNode(pRoot.right);
    }
}