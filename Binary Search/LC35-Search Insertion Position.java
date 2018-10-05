/*Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Input: [1,3,5,6], 5
Output: 2 */

//[1,3,5,6,7,10,13,15,19]
//insert 0,8,20

 
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(true){
            if(target<=nums[left])
				return left;
			if(target>nums[right])
				return right+1;
            int mid = (right + left) / 2;
            if(target <= nums[mid]){
                right = mid - 1;
            }
            if(target > nums[mid]){
                left = mid + 1;
            }
            
		}
    }
}