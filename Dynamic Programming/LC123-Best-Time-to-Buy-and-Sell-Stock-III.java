/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/


    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][6];
        
        if(prices == null || prices.length == 0){
            return 0;
        }
        
        if(prices.length == 1){
            return 0;
        }
        
        dp[0][1] = 0;
        for(int i = 2; i <=5; i++){
            dp[0][i] = Integer.MIN_VALUE;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= 5; j+=2){
                dp[i][j] = dp[i - 1][j];
                if(j > 1 && i >= 2 && dp[i - 1][j - 1] != Integer.MIN_VALUE){
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                    
                }              
           }
           for(int j = 2; j <= 5; j+=2){
               dp[i][j] = dp[i - 1][j - 1];
               if(i >= 2 && dp[i - 1][j] != Integer.MIN_VALUE){
                   dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + prices[i - 1] - prices[i - 2]);
               }
           } 
            
        }
        
        return Math.max(dp[n][1], Math.max(dp[n][3],dp[n][5]));       
    }




    