/*
A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.


Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
*/

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3){
            return 0;
        }
        int n = A.length;
        if(isArithmetic(A)){
            return (n-1) * (n-2) /2;
        }
        int res = 0;
        int count = 2;
        for(int i = 0; i < A.length - 2; i++){
            if(A[i+1] - A[i] == A[i+2] - A[i+1]){
                count++;
            }else{
                res += (count - 1) * (count - 2) / 2;
                count = 2;
            }
        }
        count = 2;
        for(int j = A.length - 1; j > 0; j--){
            if(A[j-2] - A[j - 1] == A[j - 1] - A[j]){
                count ++;
            }else{
                res += (count - 1) * (count - 2) / 2;
                break;
            }
        }
        return res;   
        
    } 
    public boolean isArithmetic(int[] arr){
        int length = arr.length;
        int value = arr[1] - arr[0];
        for(int i = 1; i < arr.length;i++){
            if(arr[i] - arr[i - 1] != value){
                return false;
            }
       }    
        return true;
    }
}

Smart Solution:
public int numberOfArithmeticSlices(int[] A) {
    int curr = 0, sum = 0;
    for (int i=2; i<A.length; i++)
        if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
            curr += 1;
            sum += curr;
        } else {
            curr = 0;
        }
    return sum;
}

DP Solution: 
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0) return 0;
        int[] index = new int[A.length];
        for(int i = 2; i < index.length; i++)
        {
        	if(A[i] - A[i - 1] == A[i - 1] - A[i - 2])
        	{
        		if(index[i - 1] == 0) index[i] = 3;
        		else index[i] = index[i - 1] + 1;
        	}
        	else index[i] = 0;
        }

        int sum = 0;
        for(int i = 0; i < index.length; i++)
        {
        	if(index[i] != 0)
        	{
        		sum += index[i] - 3 + 1;
        	}
        }
        return sum;
    }
}

