Reverse Linked List: 
public ListNode reverse(ListNode head){
    ListNode prev = null;
    while(head != null){
        //经典四步
        ListNode temp = head.next;
        head.next = prev;
        prev = head;
        head = temp;
    }
    return prev;
}