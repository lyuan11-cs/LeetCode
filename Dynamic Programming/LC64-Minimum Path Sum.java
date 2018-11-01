/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/


/*


边界情况：i = 0 or j = 0
dp[0][0] = A[0][0]

dp[i][j] = min{dp[i-1][j], dp[i][j-1]} + A[i][j]

Time : O(MN); Space: O(MN) 

空间优化：
dp[i][j] = dp[i-1][j] + dp[i][j-1]
滚动数组：

*/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int j = 1; j < n; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        
        return dp[m-1][n-1];
    }
}

Optimization:
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(m == 0 || n == 0 ){
        	return 0;
        }
        //create 2 rows of arrays
        int[][] dp = new int[2][n];
        //two pointers
        //where is row i stored: now
        //where is row i-1 stored : old

        int old, now = 0;

        for(int i = 0; i < m; i++){
        	//1.swap old and now
        	old = now;
        	now = 1 - old;
        	for(int j = 0; j < n ; j++){
        		if(i == 0 && j ==0){
        			dp[now][j] = grid[i][j];
        			continue;
        		}

        		int t = Integer.MAX_VALUE;
        		if(i>0){
        			t = Math.min(t,dp[old][j]);
        		}
        		if(j > 0){
        			t = Math.min(t,dp[now][j-1]);
        		}
        		dp[now][j] = t + grid[i][j];
        	}
        }
        return dp[now][n-1];
    }
}






