/* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Input: [3,4,5,1,2] 
Output: 1   
*/

class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }  
        if (nums[0] <= nums[nums.length - 1]) {
            // not rotated.
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {  //difference between left + 1 < right && left <= right
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}