import java.util.ArrayList;

public class E19_Medium_Remove_NthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode iter = head;
        ArrayList<ListNode> list = new ArrayList<>();
        while(iter!=null){
            list.add(iter);
            iter = iter.next;
        }

        int pos = list.size()-1-n;
        ListNode next = list.get(pos).next;
        if(pos-1<0){
            return head.next;
        }
        list.get(pos-1).next = next;
        return head;
    }

}
