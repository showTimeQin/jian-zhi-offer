/*
题目描述
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
输出描述:
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
*/

//由等差数列求和、二元一次方程求根公式得出来的答案。
import java.util.ArrayList;
public class Solution {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        int n1, n2;
        int len = (sum-1) >> 1;
       for(int i=1; i<=len; ++i){
           int delta = (int)(Math.pow(2*i-1, 2) + 8 * sum);
           
           if(delta > 0){
               n1 = (int)((1-2*i) + Math.sqrt(delta)) >> 1;
               n2 = (int)((1-2*i) - Math.sqrt(delta)) >> 1;
               findList(i, n1 > n2 ? n1 : n2, sum);
           }else if(delta == 0){
               n1 = (1-2*i) >> 1;
               findList(i, n1, sum);
           }
       }
        return lists;
    }
    
    private void findList(int i,int n, int sum){
    	//求和公式
        if(((n*n+(2*i-1)*n)>>1) == sum){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num=0; num<n; ++num){
                list.add(num+i);
            }
            lists.add(list);
        }
    }
}


/*
官方回答
双指针问题
当总和小于sum，大指针继续+
否则小指针+
 */
import java.util.ArrayList;
public class Solution {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        if (sum < 3)
            return listAll;
        int small = 1;
        int big = 2;
        int middle = (sum + 1) / 2;
        int curSum = 3;
        while (small < middle) {
            while (curSum < sum) {
                big++;
                curSum += big;
            }
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                listAll.add(list);
            }
            curSum -= small;
            small++;
        }
        return listAll;
    }
}