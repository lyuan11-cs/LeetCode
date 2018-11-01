/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
*/

/*

求以a[i] 结尾的最长上升子序列
状态：设dp[j]= 以a[j]结尾的最长上升子序列的长度；
dp[j]=max{1, dp[i]+1 | i<j and a[i]<a[j]}

情况2必须满足：
i >=0
a[j] > a[i] 满足单调性；
初始条件：空
计算dp[0] - dp[n-1]
答案是max{dp[0],dp[1]...dp[n-1]}
Time: O(n^2) 
Space: O(n)
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        if(size == 0)
            return 0;
        if(size == 1)
            return 1;
        int res = 0;
        for(int i = 1; i < size; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j])
                {
                   dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res,dp[i]);
        }    
        return res;
    }
}





class Solution {
    public int lengthOfLIS(int[] nums) {
       if(nums==null||nums.length==0) return 0;
       int[] dp=new int[nums.length+1];
        dp[1]=nums[0];
        int len=1;
       for(int i=1;i<nums.length;i++){
           int begin=1,end=len;
           while(begin!=end){
               int mid=(begin+end)/2;
               if(dp[mid]<nums[i]){
                   begin=mid+1;
               }else{
                   end=mid;
               }
           }
           if(begin==len&&nums[i]>dp[len]){
               len++;
               dp[len]=nums[i];
           }else{
               dp[begin]=nums[i];
           }   
    	}
        return len;
	}
}
