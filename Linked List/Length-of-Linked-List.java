private int getLength(ListNode node){
        int length = 0;
        while(node != null){
            length++;
            node = node.next;
        }
        return length;
    }