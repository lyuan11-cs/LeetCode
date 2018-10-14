/*
    Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
      ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode left = l1;
        ListNode right = l2; 
        
        while(left != null && right != null){
            if(left.val < right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        
        if(left != null){
            cur.next = left;
        }
        
        if(right != null)
        {
            cur.next = right;
            
        }
        return dummy.next;
        
        
    }
}