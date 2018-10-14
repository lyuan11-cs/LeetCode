/*
Given a linked list, remove the n-th node from the end of list and return its head.
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0);
        
        dummy.next = head; 
        
        ListNode cal = dummy;
        
        for(int i = 0; i < n; i++)
        {
            if(head == null)
                return null;
            
            head = head.next;
        }
        
        while(head != null){
            head = head.next;
            cal = cal.next;
        }
        cal.next = cal.next.next;
        
        return dummy.next;
        
    }
}