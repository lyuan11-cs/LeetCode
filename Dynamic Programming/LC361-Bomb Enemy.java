/*Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)

*/

public class Solution{
	public int maxKilledEnemies(char[][] A){
		if(A == null || A.length == 0 || A[0].length == 0){
			return 0;
		}

		int m = A.length;
		int n = A[0].length;
		int[][] up = new int[m][n];
		int[][] down = new int[m][n];
		int[][] left = new int[m][n];
		int[][] right = new int[m][n];


		int res = 0;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(A[i][j] == 'W'){
					up[i][j] = 0;
					continue;
				}

				up[i][j] = A[i][j] == 'E'? 1:0;
				if(i > 0 ){
					up[i][j] += up[i - 1][j];
				}
			}
		}
		//order
		for(int i = m - 1; i >= 0 ; i--){
			for(int j = 0; j < n; j++){
				if(A[i][j] == 'W'){
					down[i][j] = 0;
					continue;
				}

				down[i][j] = A[i][j] == 'E'? 1:0;
				if(i < m - 1 ){
					down[i][j] += down[i - 1][j];
				}
			}
		}

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(A[i][j] == 'W'){
					left[i][j] = 0;
					continue;
				}

				left[i][j] = A[i][j] == 'E'? 1:0;
				if(j > 0 ){
					left[i][j] += left[i][j - 1];
				}
			}
		}

		for(int i = 0; i < m ; i++){
			for(int j = n - 1; j >= 0; j--){
				if(A[i][j] == 'W'){
					right[i][j] = 0;
					continue;
				}

				right[i][j] = A[i][j] == 'E'? 1:0;
				if(j < n - 1){
					right[i][j] += right[i][j + 1];
				}
			}
		}

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n ; j++){
				if(A[i][j] == '0'){
					int t = up[i][j] + down[i][j] + left[i][j] + right[i][j];
					res = Math.max(t,res);
				}
			}
		}


	}
}