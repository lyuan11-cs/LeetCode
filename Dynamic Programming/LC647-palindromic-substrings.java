/*
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.
*/

class Solution {
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        boolean[][] res = isPalind(arr);
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(res[i][j]){
                    count++;
                }
            }
        }
        return count;      
    }
    public boolean[][] isPalind(char[] s){
        int n = s.length;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n; j++){
                dp[i][j] =false;
            }
        }     
        for(int c = 0; c < n; c++){
            int i = c;
            int j = c;
            while(i>=0 && j<n && s[i] == s[j]){
                dp[i][j] = true;
                i--;
                j++;       
            }
        }
        for(int c = 0; c < n - 1; c++){
            int i = c;
            int j = c + 1;
            while(i>=0 && j<n && s[i] == s[j]){
                dp[i][j] = true;
                i--;
                j++;
            }
        }
        return dp;        
    }
}