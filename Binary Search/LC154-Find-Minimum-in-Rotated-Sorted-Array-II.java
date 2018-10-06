/* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Input: [2,2,2,0,1]
Output: 0
*/

class Solution {
    public int findMin(int[] nums) {
       if (nums == null || nums.length == 0) {
	        return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {                     
            while (nums[left] == nums[right] && left != right) {  // Skip the duplicate element
                left++;
            }
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1; // Right half is sorted. Left half is unsorted
            } else {
                right = mid;// Left half is sorted. right half is unsorted
            }
        }
         return nums[left];
    }
}