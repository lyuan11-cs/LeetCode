/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpmax = new int[n];
        int[] dpmin = new int[n];
        
        int res = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            dpmax[i] = nums[i];
            dpmin[i] = nums[i];
            if(i > 0){
                dpmax[i] = Math.max(dpmax[i],Math.max(dpmax[i-1] * nums[i], dpmin[i-1]*nums[i])); 
                dpmin[i] = Math.min(dpmin[i],Math.min(dpmax[i-1] * nums[i], dpmin[i-1]*nums[i]));
            }
            if(res < dpmax[i]){
                res = dpmax[i];
            }       
        }
        return res;
    }
}


Optimization: 
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(nums[i], min * nums[i]);
            max = Math.max(nums[i], max * nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }
}