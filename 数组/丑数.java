/*
题目描述
把只包含因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。
求按从小到大的顺序的第N个丑数。
*/

import java.util.*;
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 1)
        	return index;
		ArrayList<Integer> list = new ArrayList<>();
        int two = 0;
        int three = 0;
        int five = 0;
        int count = 1;
        int min = Integer.MIN_VALUE;
        list.add(1);
        
        while(count<index){
            min = Math.min(list.get(two)*2,Math.min(list.get(three)*3,list.get(five)*5));
            list.add(min);
            ++count;
            if(list.get(two)*2 == min){
                ++two;
            }
            if(list.get(three)*3 == min){
                ++three;
            }
            if(list.get(five)*5 == min){
                ++five;
            }
    
        }
        return list.get(list.size()-1);
    }
}