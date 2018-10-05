/*Given a list of sorted characters letters containing only lowercase letters, 
and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.*/

/*Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"*/

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
         if (letters[letters.length - 1] <= target) {
            return letters[0];
        }
        int left = 0;
        int right = letters.length - 1;
        
        while (left + 1 < right) {      //key point 1 : while termination condition;
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {  //key point 2: when is > or >= 
                left = mid;   //key point 3: left = mid or left = mid + 1;
            } else {
                right = mid;  //key point 4:  
            }
        }
        if (letters[left] > target) {  //key point 5: whether it's required to use if again;
            return letters[left];
        } else {
            return letters[right];
        }
    }
}