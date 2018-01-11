/*
题目描述
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
输入描述:
题目保证输入的数组中没有的相同的数字
数据范围：
	对于%50的数据,size<=10^4
	对于%75的数据,size<=10^5
	对于%100的数据,size<=2*10^5
示例1
输入

1,2,3,4,5,6,7,0
输出

7
*/

/*
分治法 -- 归并排序
https://www.nowcoder.com/questionTerminal/96bd6684e04a44eb80e6a68efc0ec6c5
图片在上面的网站

这里还使用了滚动数组的思想

*/

public class Solution {
    private final int NUM = 1000000007;
    public int InversePairs(int [] array) {
		if(array == null || array.length == 0){
            return 0;
        }
        int[] copy = new int[array.length];
        // 把array的内容复制到copy,使得进入递归的最底层时，array和copy一样
        for(int i = 0;i < array.length;i++){
            copy[i] = array[i];
        }
        //返回逆序对的总数P
        int count = (int)InversePairsCore(array,copy,0,array.length-1);//数值过大求余
        return count;
    }
    
	private long InversePairsCore(int[] array,int[] copy,int low,int high){
        if(low == high){
            return 0L;
        }
        int mid = (low+high) >> 1;
        //把数组分为左右两部分
        long leftCount = InversePairsCore(copy,array,low,mid)%NUM;
        long rightCount = InversePairsCore(copy,array,mid+1,high)%NUM;
        long count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while(i >= low && j > mid){
            if(array[i] > array[j]){
                //如果7大于6，则7也一定大于6前面的数
                count += j - mid;
                copy[locCopy--] = array[i--];       
            }else{
                copy[locCopy--] = array[j--];
            }
        }
        if(count >= NUM){//数值过大求余
            count %= NUM;
        }
        for(;i>=low;i--){
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--){
            copy[locCopy--]=array[j];
        }
        return (leftCount+rightCount+count)%NUM;
    }
}