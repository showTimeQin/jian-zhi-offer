
/*
题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
*/

/*
斐波那契数列的变形。不要用递归。
*/

public class Solution {
    public int JumpFloor(int target) {
		int preNum = 2;
        int prePreNum = 1;
        int result = 0;
        if(target <= 2)
            return target;
		for(int i=2; i<target;++i){
            result = prePreNum + preNum;
            prePreNum = preNum;
            preNum = result;
        }
        return result;
    }
}