/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
*/

/*
􏵐􏱀􏲄􏱝􏲒􏱙􏴓􏳎􏳑􏴍􏲟􏰇􏲄􏱝􏱒􏱣􏰇􏲄􏱝􏱺􏰂􏳷􏱵􏱝􏵘
划分型动态规划
最后一步：对应一个字母 - A-Z
子问题：
设数字串长度为N；
求数字串前N个字符的解密方式数；
需要知道数字串前N-1和N-2个字符的解密方式数

状态：设数字串S前i个数字解密成字母串有dp[i] 种方式；

转移方程：
dp[i] = dp[i-1]|S[i-1]对应一个字母 + dp[i-2] | S[i-2]S[i-1]对应一个字母
初始条件：dp[0] = 1 空串有1种方式解密；
dp[0] - dp[n]
Time: O(N)
Space:O(N)
*/
class Solution {
    public int numDecodings(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int[] dp = new int[n + 1];
        if(n == 0){
            return 0;
        }
        dp[0] = 1;
        
        for(int i = 1; i <= n;i++){
            if(str[i-1] >= '1' && str[i-1] <= '9'){
                dp[i] += dp[i-1];
            }
            if(i > 1){
                int j = 10 * (str[i-2] - '0') + (str[i-1] - '0');
                if(j >=10 && j <=26){
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[n];
    }
}