/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
*/

    public int maxProfit(int k, int[] prices) {        
        int n = prices.length;       
        if(n == 0 || prices == null){
            return 0;    
        }   
        if(k >= n/2){
            int sum = 0;
            for(int i = 0; i < n -1;i++){
                if(prices[i] < prices[i+1]){
                    sum += prices[i+1] - prices[i];
                }
            }
            return sum;
        }   
        
        int[][] f =new int[n + 1][2*k +2];
        //unit
        f[0][1] = 0;   
       for(int i = 2; i <= 2*k + 1; i++){
           f[0][i] = Integer.MIN_VALUE;
       }
        
        for(int i = 1; i <= n ; i++){
            
            for(int j = 1; j <=2 * k + 1 ; j += 2){
                f[i][j] = f[i - 1][j];
                
                if(j > 1 && i >= 2 && f[i-1][j-1] != Integer.MIN_VALUE){
                    f[i][j] = Math.max(f[i][j], f[i-1][j-1] + prices[i-1] - prices[i-2]);
                }
            }
        
            for(int j = 2; j <= 2 * k ; j+=2){
                f[i][j] = f[i-1][j-1];
                if(i >= 2 && f[i-1][j] != Integer.MIN_VALUE){
                    f[i][j] = Math.max(f[i][j], f[i-1][j] + prices[i-1] - prices[i-2]);
                }
            }
        }
        
       int res = Integer.MIN_VALUE;
        for(int i = 1; i <= 2* k + 1; i += 2){
            res = Math.max(res, f[n][i]);
        }
        
        return res;
    }