/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
*/

/*
最后一步：
情况1：不偷房子N-1
	简单，最优策略就是前N-1栋房子的最优策略
情况2：偷房子N-1
	仍然需要知道在前N-1栋房子中最多能偷多少金币；但是，需要保证不偷第N-2栋房子

设dp[i] 为窃贼在前i栋房子最多偷多少金币
dp[i] = max{dp[i-1], dp[i-2] + A[i-1]}
初始条件：
dp[0] = 0;
dp[1] = A[0];
dp[2] = Max{A[0],A[1]}

from dp[1] to dp[n]
Time: O(N); Space: O(1)
*/

class Solution {
    public int rob(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        } 
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];
        dp[2]=Math.max(nums[0],nums[1]);
        for(int i = 3; i <= n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i-1]);
        }
        return dp[n];
    }
}
Optimization:
public class Solution{
    public long houseRobber(int[] A){
        int n = A.length;
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return A[0];
        }

        long old = 0;
        long now = A[0];

        for(int i = 2;i <= n; ++i){
            long t = Math.max(now, old + A[i - 1]);
            old = now;
            now = t;
        }

        return now;
    }
}

Optimization:
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[2];
        for (int i = n - 1; i >= 0; i--) {
            int val = Math.max(dp[0], nums[i] + dp[1]);
            dp[1] = dp[0];
            dp[0] = val;
        }
        return dp[0];
    }
    
  }



