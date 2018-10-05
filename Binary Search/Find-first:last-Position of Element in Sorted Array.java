First Position of Target
public class Solution{
	public int binarySearch(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return -1;
		}

		int start = 0, end = nums.length - 1;

		while(start + 1 < end){
			//int mid = (start + end ) / 2 ( avoid 2^31) 
			int mid = (end - start)/2 + start;

			if(target == nums[mid]){
				end = mid;
			}else if(target < nums[mid]){
				//end = mid - 1;
				end = mid;
			}else{
				//start = mid + 1;
				start = mid;
			}
		}
		//double check
		if(nums[start] == target){
			return start；
		}
		if(nums[end] == target){
			return end;
		}
		return -1;
	}
}

Last Position of Target
public class Solution{
	public int binarySearch(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return -1;
		}

		int start = 0, end = nums.length - 1;


		//start < end;
		//dead loop using "start = mid " 
		while(start + 1 < end){
			//int mid = (start + end ) / 2 ( avoid 2^31) 
			int mid = (end - start)/2 + start;

			if(target == nums[mid]){
				start = mid;
			}else if(target < nums[mid]){
				//end = mid - 1;
				end = mid;
			}else{
				//start = mid + 1;
				start = mid;
			}
		}

		//double check
		if(nums[start] == target){
			return start；
		}
		if(nums[end] == target){
			return end;
		}
		return -1;
	}
}