/*
Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 
Example 2:
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1. 
Note: Length of the array will not exceed 10,000.
*/

/*

状态：􏲱设dp[j] =以􏱯a[j]结尾的最长连续上升子序列的长度􏰤􏲻􏵙􏴲􏳳􏰊􏰑􏲞􏲢􏴷􏳶􏴉􏵙􏳳􏲥
转移方程：
dp[j] = max{ 1, dp[j–1]+1| j>0 and a[j-1] < a[j]}
情况2必须满足：
 j>0, 􏱙即a[j]前面至少还有一个元素；􏴜􏵏􏵠􏳫􏲤􏱮􏳷􏱵􏳱􏳞
 a[j] > a[j-1]，满足单调性
Time:O(n); Space:O(n)
*/

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
       
        
        for(int i = 0 ; i < n; i++){
            dp[i] = 1;
            if(i > 0 && nums[i-1] < nums[i]){
                dp[i] = dp[i-1] + 1;
            }
            if(max < dp[i]){
                max = dp[i];
            }
        }       
        return max;
    }
}


public class Solution{
	public void LIS(int[] A, int n){
		int i,j;
		int[] f = new int[n];
		int res = 0;

		for(i = 0; i < n; ++i){
			f[i] = 1;

			if(i > 0 && A[i] > A[i - 1]){
				f[i] = f[i - 1] + 1;
			}

			res = Math.max(res,f[i]);
		}


		return res;
	}

	public int longestIncreasingContinuousSubsequence(int[] A){
		int n = A.length;
		if(n == 0){
			return 0;
		}

		int r1 = LIS(A,n);
		//reverse the array.. 
		int i,j,t;
		i = 0;
		j = n - 1;
		while(i < j){
			t = A[i];
			A[i] = A[j];
			A[j] = t;
			++i;
			--j;
		}

		int r2 = LIS(A,n);
		return r1 > r2? r1:r2;
	}
}
