/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

*/


/*
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
*/


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
        return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int n = row * col -1;
        int x, y;
        int start = 0;
        int end = n;
        while(start <= end)
        {
            int mid =(start + end)/2;
            x = mid/ col;
            y = mid % col;
            if(matrix[x][y] == target)
            {
                return true;
            }
            else if(matrix[x][y] > target)
            {
                end = mid -1;
            }
            else
                start = mid +1;
        }
        return false;
    }
}