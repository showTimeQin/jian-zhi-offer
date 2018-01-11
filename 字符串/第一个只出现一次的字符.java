/*
在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
并返回它的位置
*/

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        int[] postion = new int[255];
        char[] c = str.toCharArray();
        
        for(int i = 0; i < c.length; ++i){
            if(postion[c[i]] == 0){	//0为null
                postion[c[i]] = i+1;
            }else if(postion[c[i]] > 0){
                postion[c[i]] = -1;	//-1为重复
            }
        }
        
        for(int i = 0; i < c.length; ++i){
            if(postion[c[i]] > 0){
                return postion[c[i]] - 1;
            }
        }
        
        return -1;
    }
}