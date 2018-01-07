/*
题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
超过数组长度的一半，因此输出2。如果不存在则输出0。
*/

/*
如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
在遍历数组时保存两个值：一是数组中一个数字，一是次数。遍历下一个数字时，
若它与之前保存的数字相同，则次数加1，否则次数减1；若次数为0，则保存下一个数字，
并将次数置为1。遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。
*/

import java.util.*;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0) return 0;
        // 遍历每个元素，并记录次数；若与前一个元素相同，则次数加1，否则次数减1
        int result = array[0];
        int times = 1; // 次数
        
		for (int i = 1;i < array.length;++i){
            if (times == 0){
                // 更新result的值为当前元素，并置次数为1
                result = array[i];
                times = 1;
            }else if(array[i] == result){
                ++times; // 相同则加1
            }else{
                --times; // 不同则减1               
            }
        }
        
		// 判断result是否符合条件，即出现次数大于数组长度的一半
        times = 0;
        for(int i = 0;i < array.length;++i){
            if(array[i] == result) ++times;
        }
         
        return (times > array.length/2) ? result : 0;
    }
}