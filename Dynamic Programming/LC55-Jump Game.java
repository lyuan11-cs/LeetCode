/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
*/
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        
        for(int i = 1; i < n; i++){
            dp[i] = false;
            for(int j = 0; j < i;j++){
                if(dp[j] == true && j + nums[j] >= i ){
                    dp[i] = true;
                    break;
                }
            }
        }    
        return dp[n-1];
    }
}

Optimization:

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length < 2) return true;
        boolean[] jumps = new boolean[nums.length];
        int target = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= target) {
                jumps[i] = true;
                target = i;
            }
        }
        return jumps[0];
    }
}