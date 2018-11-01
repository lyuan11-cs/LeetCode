/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]
*/

/*

最后一步： 观察这个数最后一个二进制位，去掉它，看剩下多少个1；
子问题：
在N 的二进制去掉最后一位 N mod 2， 设新的数是Y =(N >> 1)(右移一位)

状态：设dp[i] 表示i的二进制表示中有多少个1；
dp[i] = dp[i>>1] + (i mod 2)
初始条件：dp[0] = 0

时间复杂度：O(N);
空间复杂度: O(N);
*/


class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for(int i = 1 ; i <= num ; i++){
            dp[i] = i%2 + dp[i >> 1];
        }
        return dp;
    }
}