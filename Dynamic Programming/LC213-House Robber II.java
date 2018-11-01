/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
*/

/*
房子0和房子N-1成了邻居，不能同时偷盗；
要么没偷房子0，要么没偷房子N-1；
情况1：没偷房子0；
盗贼对1-N-1 偷盗的最优策略-> 化为House Robber I

情况2：没偷房子N-1
最优策略就是窃贼对于房子0-N-2的最优策略-> 化为House Robber；
*/

class Solution {
    public int calc(int[] A){
        if(A == null || A.length == 0){
            return 0;
        }    
        if(A.length == 1)
            return A[0];
        int[] dp = new int[A.length + 1];
        dp[0] = 0;
        dp[1] = A[0];
        dp[2] = Math.max(A[0], A[1]);
        for(int i = 3; i <= A.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i -2] + A[i - 1]);
        }
        
        return dp[A.length];
    }   
    public int rob(int[] nums) {
        int n = nums.length;      
        if(nums.length == 0 || nums == null){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[n - 1];
        int res = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < n - 1; i++){
            dp[i] = nums[i];
        } 
        res = Math.max(res, calc(dp));
        for(int i = 0 ; i < n - 1; i++){
            dp[i] = nums[i + 1];
        }
         res = Math.max(res, calc(dp)); 
        return res;
    }
}