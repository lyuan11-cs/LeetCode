/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
*/

public int lengthOfLIS(int[] nums) {
       if(nums==null||nums.length==0)
           return 0;
       int[] dp=new int[nums.length];
       if(nums.length == 1){
           return 1;
       } 
       int max = Integer.MIN_VALUE;
       for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
           for(int j = 0; j < i; j++){
               if(nums[i] > nums[j]){
                   dp[i] = Math.max(dp[i],dp[j]+1);
               }       
           }
           if(dp[i] > max){
               max = dp[i];
           }
    	}
        return max;
    }