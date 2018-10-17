/*
Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
			return head;
		ListNode curr = head;
		ListNode next = head.next;
		ListNode newHead = next;
		
		curr.next = next.next;
		next.next = curr;
		
		if (curr.next == null)
			return newHead;
		
		while (curr.next.next != null) {
			ListNode prev = curr;
			curr = curr.next;
			next = curr.next;
		
			prev.next = next;
			curr.next = next.next;
			next.next = curr;
			
			if (curr.next == null || curr.next.next == null)
				break;
				
		}
		
		return newHead;
    }
}

