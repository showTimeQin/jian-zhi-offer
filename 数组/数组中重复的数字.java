/*
题目描述
在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 数组中某些数字是重复的，但不知道有几个数字是重复的。
 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 
 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
*/

/*
利用现有数组设置标志，当一个数字被访问过后，可以设置对应位上的数 + n，
之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可。
使用-而不用+是为了防止溢出。
空间复杂度为O(1), 时间复杂度为O(n), 但是改变了数组
*/
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

//boolean只占一位，所以还是比较省的
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if(numbers==null || numbers.length == 0)
            return false;
        
        int index = 0;
        for(int i=0; i<numbers.length; ++i){
            index = numbers[i];
            if(index < 0){
                index += length;
            }
            if(numbers[index] < 0){
                duplication[0] = index;
                return true;
            }
            numbers[index] -= length;
        }
        return false;
    }
}

/*
使用数组辅助空间
时间复杂度为O(n), 空间复杂度为O(n), 没有改变数组
 */
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
 
//boolean只占一位，所以还是比较省的
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if(numbers==null || numbers.length == 0)
            return false;
         
        boolean[] array = new boolean[length];
        for(int number:numbers){
            if(array[number]){
                duplication[0] = number;
                return true;
            }else{
                array[number] = true;
            }
        }
        return false;
    }
}