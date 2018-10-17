/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null ){
            return null;
        }        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        
        while(head.next != null ){
            if(head.next.val == val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }   
        }        
        return dummy.next;
    }
}