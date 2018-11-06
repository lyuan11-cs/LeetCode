/*
有N本书需要被抄写，第i本书有A[i]页，i=0, 1, ..., N-1
• 有K个抄写员，每个抄写员可以抄写连续的若干本书(例如:第3~5本书， 或者第10本书)
• 每个抄写员的抄写速度都一样:一分钟一页
• 最少需要多少时间抄写完所有的书
• 例子:
• 输入:
– A = [3, 2, 4], K=2
• 输出:
– 5 (第一个抄写员抄写第1本和第2本书，第二个抄写员抄写第3本书)
*/

/*
求K个人最短需要多少时间抄完前N本书
• 需要知道K-1个人最少需要多少时间抄完前j本书
• 子问题
• 状态:设f[k][i]为前k个抄写员最少需要多少时间抄完前i本书
f[k][i] = minj=0,...,i{max{f[k-1][j], A[j] +... +A[i-1]}}

k个抄写员最少需要多少 时间抄完前i本书

k-1个抄写员最少需要多少时 间抄完前j本书
第k个抄写员抄完第j至第i-1 本书的时间

初始条件：
 0个抄写员只能抄0本书
• f[0][0] = 0, f[0][1] = f[0][2] = ... = f[0][N] = +∞
– k个抄写员(k>0)需要0时间抄0本书 • f[k][0] = 0 (k > 0)
f[K][N]
*/

public class Solution{
	public int copyBooks(int[] A, int K){
		int n = A.length;
		if(n == 0){
			return 0;
		}


		int[][] dp = int[K + 1][n + 1];
		int i,j,k;
		dp[0][0] = 0;
		//initializing... 
		for(int i = 1; i <= n; i++){
			dp[0][i] = Integer.MAX_VALUE;
		}


		for(k = 1; k <= K; k++){
			dp[k][0] = 0;
			for(i = 1; i <= n; i++){
				f[k][i] = Integer.MAX_VALUE;
				//A[j] + ...A[i - 1]
				int sum = 0;
				for(j = i; j >= 0;j--){
					//sum = A[j] + ... + A[i - 1]
					//f[k][i] = minj= 0,...,i{max{f[k-1][j], A[j] + ... + A[i - 1]}}
					f[k][i] = Math.min (f[k][i], Math.max(f[k-1][j], sum));

					if(j > 0){
						sum += A[j - 1];
					}
				}
			}
		}

		return f[K][n];
	}
}