import java.util.HashSet;

public class E141_Easy_Linked_LIst_Cycle {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visit = new HashSet<>();

        while (head != null) {
            if (!visit.add(head)) {
                return true;
            }
            head = head.next;
        }

        return false;

    }

}
