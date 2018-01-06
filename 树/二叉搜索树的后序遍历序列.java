/*
题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
*/

/*
第一种 全是右子树 i=start 调用最后的ju 左子树直接返回true  右子树递归递归最后root-1=i=start return true
第二种  全是左子树 i=root 最后的ju 左子树递归递归 最后root-1=start返回true 右子树直接返回true
第三种 左子树右子树都有正常递归 继续直到进入前面两种情况之一
*/

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)
            return false;
        return ju(sequence, 0, sequence.length-1);
          
    }
      
    public boolean ju(int[] a,int star,int root){
        if(star>=root)
            return true;
        int i = root;
        //从后面开始找
        while(i>star&&a[i-1]>a[root])
            i--;//找到比根小的坐标
        //从前面开始找 star到i-1应该比根小
        for(int j = star;j<i-1;j++)
            if(a[j]>a[root])
                return false;;
        return ju(a,star,i-1)&&ju(a, i, root-1);
    }
}