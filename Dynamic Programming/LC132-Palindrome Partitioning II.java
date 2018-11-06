/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/


public class Solution{

	private boolean[][] calPalin(char[] s){
		int n = s.length;
		boolean[][] f = new boolean[n][n];
		int i,j,c;
		for(i = 0; i < n ;i++){
			for(j = 0; j < n; j++){
			f[i][j] = false;
			}
		}

		//odd length
		//center character

		for(c = 0; c < n; c++){
			i = j = c;
			//extend to both directions
			while(i >= 0 && j < n && s[i] == s[j]){
				f[i][j] = true;
				i--;
				j++;

			}
		}

		//even length
		//center line

		for(c = 0; c < n-1; c++){
			i = c;
			j = c + 1;
			//extend to both directions
			while(i >= 0 && j < n && s[i] == s[j]){
				f[i][j] = true;
				i--;
				j++;
			}
		}

		return f;


	}
	public int minCut(String s){
		//write your code here
		char[] arr = s.toCharArray();
		int n = arr.length;
		if(n == 0){
			return 0;
		}

		boolean[][] isPalin = calcPalin(arr);
		int i,j;
		int[] dp = new int[n + 1];
		dp[0] = 0;  //initializing condition; 

		for(i = 1; i <= n; i++){
			dp[i] = Integer.MAX_VALUE;
			for(j = 0; j < i; j++){
				if(isPalin[j][i - 1]){
					dp[i] = Math.min(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[n] - 1;
	}
}