/*Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
*/

public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashset = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0 ;
        int j = 0 ;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] > nums2[j]){
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                hashset.add(nums1[i]);
                i++;
                j++;
            }
        
        }
        
        int[] result = new int[hashset.size()];
        int k = 0;
        for (Integer num : hashset) {
            result[k++] = num;
        }
        return result;
       
    }