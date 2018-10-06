/* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
*/

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] < nums[mid]){
                if(nums[mid] >= target && nums[left] <= target){
                    right = mid;
                }else{
                    left = mid;
            }
        }
            else{
                if(nums[mid] <= target && nums[right] >= target){
                    left = mid;
                }else{
                    right = mid;
                }
            }
        }
            if(nums[left] == target){
                return left;
            }
            if(nums[right] == target){
                return right;
            }
    
        return -1;
    }
}