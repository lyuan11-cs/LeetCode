/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
        private ListNode findMiddle(ListNode head){
            ListNode slow = head;
            ListNode fast = head;
            
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            
            return slow;
        }      
        private ListNode reverse(ListNode head){
            ListNode newHead = null;
            while(head != null)
            {
                ListNode temp = head.next;
                head.next = newHead;
                newHead = head;
                head = temp;
                
            }
            return newHead;
        }
        private ListNode merge(ListNode left, ListNode right){
            int index = 0;
            ListNode dummy = new ListNode(0);
            
            while(left != null && right != null){
                if(index % 2 == 0 ){
                    dummy.next = left;
                    left = left.next;
                }else{
                    dummy.next = right;
                    right = right.next;
                }
                dummy = dummy.next;
                index++;
            }           
            if(left != null)
                dummy.next = left;
            if(right != null ) 
                dummy.next = right;
            
            return dummy.next;
        }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;
        merge(head,tail);
        
    }
}