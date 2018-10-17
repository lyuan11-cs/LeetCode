/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
    if(head == null || head.next == null){
        return null; 
    }
        
    ListNode fast = head;
    ListNode slow = head;
        
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next; 
        
        if(fast == slow){
            fast = head;
            
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            
            return fast;
        }
    }
        
        return null;
    }
}