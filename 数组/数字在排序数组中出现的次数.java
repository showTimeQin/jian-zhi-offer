/*
题目描述
统计一个数字在排序数组中出现的次数。
*/

//由于数组有序，所以使用二分查找方法定位k的第一次出现位置和最后一次出现位置

public class Solution {
    public int GetNumberOfK(int [] array , int k) {
		int lower = getLower(array,k);
        int upper = getUpper(array,k);
         
        return upper - lower + 1;
    }
    
	//获取k第一次出现的下标
    private int getLower(int[] array,int k){
        int start = 0,end = array.length-1;
        int mid = (start + end) >> 1;
         
        while(start <= end){
            if(array[mid] < k){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            mid = (start + end) >> 1;
        }
        return start;
    }

	//获取k最后一次出现的下标
    int getUpper(int[] array,int k){
         int start = 0,end = array.length-1;
        int mid = (start + end) >> 1;
         
        while(start <= end){
            if(array[mid] <= k){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            mid = (start + end) >> 1;
        }
         
        return end;
    }
}