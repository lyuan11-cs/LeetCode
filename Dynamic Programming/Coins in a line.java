/*
题意:
• 有一排N个石子，Alice, Bob两人轮流取石子
• 每次一个人可以从最右边取走1个或2个石子
• 取走最后石子的人胜
• 问先手Alice是否必胜 (先手必胜: true,先手必败: false)
• 例子:
• 输入:N=5
• 输出:true (先手取走2个石子，剩下3个石子，无论后手怎么拿，先手 都可以取走最后一个石子）
*/
//设f[i]表示面对i个石子，是否先手必胜(f[i] = TRUE / FALSE)
public class Solution{
	public boolean firstWillWin(int n){
		if(n == 0){
			return false;
		}
		if(n == 1){
			return true;
		}
		boolean[] dp = new boolean[n + 1];
		dp[0] = false;
		dp[1] = true;

		for(int i = 2; i <= n; i++){
			dp[i] = (!dp[i - 1]) || (!dp[i - 2]);
		}
		//for(int i = 0; i <= n; i++)
			//{ System.out.println(i + ": " + f[i]); }
		return dp[n];
	}
}