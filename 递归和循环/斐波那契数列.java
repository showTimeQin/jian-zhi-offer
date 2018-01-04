/*
题目描述
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
n<=39
 */

/*
 不要用递归，会爆栈
 */
public class Solution {
    public int Fibonacci(int n) {
        int preNum = 1;
        int prePreNum = 0;
        int result = 0;
        if(n <= 1)
            return n;
		for(int i=0; i<n-1;++i){
            result = prePreNum + preNum;
            prePreNum = preNum;
            preNum = result;
        }
        return result;
    }
}