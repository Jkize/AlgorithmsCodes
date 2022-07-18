public class E82_Remove_Duplicates_From_Sorted_List_II {
    public ListNode deleteDuplicatesV2(ListNode head) {
        // use two pointers, slow - track the node before the dup nodes,
        // fast - to find the last node of dups.
        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next; // while loop to find the last node of the dups.
            }
            if (slow.next != fast) { // duplicates detected.
                slow.next = fast.next; // remove the dups.
                fast = slow.next; // reposition the fast pointer.
            } else { // no dup, move down both pointer.
                slow = slow.next;
                fast = fast.next;
            }

        }
        return dummy.next;
    }
    public ListNode deleteDuplicatesV3(ListNode head) {
        // sentinel
        ListNode sentinel = new ListNode(0, head);

        // predecessor = the last node 
        // before the sublist of duplicates
        ListNode pred = sentinel;
        
        while (head != null) {
            // if it's a beginning of duplicates sublist 
            // skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // move till the end of duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;    
                }
                // skip all duplicates
                pred.next = head.next;     
            // otherwise, move predecessor
            } else {
                pred = pred.next;    
            }
                
            // move forward
            head = head.next;    
        }  
        return sentinel.next;
    }

    public  ListNode deleteDuplicates(ListNode head) {
        if(head==null)return head;
        ListNode dst = new ListNode(0);
        ListNode curr = dst;
        
        ListNode before = null;
        ListNode middle = head;
        ListNode after =  null;
        while(middle!=null){
            after = middle.next;
            if( (before ==null || before.val!=middle.val ) && (after==null ||  after.val!=middle.val) ){
                curr.next = middle;
                curr=curr.next; 
            } 
            before = middle;
            middle = middle.next; 
        }
        curr.next = null; //Necesary in case 
        return dst.next;
    }
}
