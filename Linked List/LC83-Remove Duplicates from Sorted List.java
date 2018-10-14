/*
    Given a sorted linked list, delete all duplicates such that each element appear only once.
    Input: 1->1->2->3->3
    Output: 1->2->3
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode current = head;
        
        while(current != null && current.next != null){
            
            
            
            if(current.next.val == current.val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
            
        }
        return head;
    }
}