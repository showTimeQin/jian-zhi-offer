/*
题目描述
每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
HF作为牛客的资深元老,自然也准备了一些小游戏。
其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
然后,他随机指定一个数m,让编号为0的小朋友开始报数。
每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
*/

/*
对下标做出一些规定：0, 1, ..., n - 1这n个数字排成一个圆圈，从0开始计数，
每数到m时删除该数字，记作f(n, m)

因为该题只需要求最后剩下的数字，不需要输出每次删除的结果，所以可以使用数学的方法解决。

对于f( n, m )，第一个被删除的数字k = ( m - 1 ) % n

删除k之后序列如下，该序列已经失去了连续性

0 1 ......  k-2 k-1 k+1 k+2 ......  n-2 n-1

将k+1作为序列的开头，重新组织如下，该序列又恢复了连续性，这里的连续性是指模n连续

k+1 k+2 ......  n-2 n-1 0 1 ......  k-2 k-1

重新组织后，下标发生了变化，使用另一套下标系统，上述序列的解记为f'(n-1, m)，而f'(n-1, m)和f(n, m)是相等的

再对序列重新编号，又回到了原来的下标系统，可以记为f(n-1, m)

0 1 ...... n-k-3 n-k-2 n-k-1 n-k ......  n-3 n-2

找出两套下表系统的相互转换公式

f --> f'，p(x) = (x-k-1) % n

f' --> f，p^{-1} (x) = (x+k+1) % n

从而有f(n, m) = f'(n-1, m) = p^{-1} (f(n-1, m)) = (f(n-1,m)+k+1) % n

最后代入k = (m-1) % n，得f(n,m) = (f(n-1,m) + k + 1 ) % n = ( f( n - 1, m ) + m ) % n

边界为n=1时，f( n, m ) = 0

最终的递推公式如下

f(n, m) = 0  n = 1 
f(n, m) =(f(n-1, m) + m) % n  n >= 2

 */
import java.util.LinkedList;

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
       
        if (n <= 0) {
                return -1;
        }
        int last = 0;
        for(int i=2;i<=n;++i){
            last = (last+m)%i;
        }
        return last;
    }
}



//采用模拟环的方式实现
import java.util.LinkedList;
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        int removeIndex = 0;
        
        if(n == 0) return -1;
        
        //用一个list来记录小朋友们的编号
        for(int i=0; i<n; ++i){
            list.add(i);
        }
        
        while(list.size() > 1){
            //记录本次被删除的小朋友的编号
            removeIndex = (removeIndex + m - 1) % list.size();
            list.remove(removeIndex);
        }
        return list.get(0);
    }
}