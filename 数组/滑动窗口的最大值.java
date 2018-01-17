/*
题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， 
{2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        
        if(size > num.length || size <= 0) return list;
        
        int max = num[0];	//记录最大值
        int maxIndex = -1;	//记录最大值的位置
        int[] slideWindow = new int[]{0, size - 1};	//模拟滑动窗口
        int newNum;
        
        
        
        for(int i=0; i<num.length - size + 1; ++i){
            if(maxIndex >= slideWindow[0] && maxIndex <= slideWindow[1]){
                newNum = num[size+i-1];	//只跟最新的数比较
                if(newNum > max){
                    max = newNum;
                    maxIndex = size+i-1;
                }
            }else{
                //从窗口中找到最大的数
                max = num[i];
                for(int j=i+1; j<size+i; ++j){
                	max = num[j] > max ? num[j] : max;
            	}
            }
            
            list.add(max);
            ++slideWindow[0];
            ++slideWindow[1];
        }
        return list;
    }
}