import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class E23_Hard_Merge_K_Sorted_List {

    public ListNode mergeKListsV2(ListNode[] lists) {
        // Java convention: compare(a, b) is negative if a < b, positive if a > b
        Comparator<ListNode> comp = (ListNode a, ListNode b) -> a.val - b.val;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(11, comp);
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        

        ListNode head = new ListNode(0);
        ListNode combined = head;
        while (queue.size() > 0) {
            // Remove pointer with smallest value
            ListNode curr = queue.poll();

            combined.next = curr;
            combined = combined.next;

            // Only add pointer back in if it is not null
            if (curr.next != null) {
                queue.add(curr.next);
            }
        }

        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode res = null;
        for (int i = 0; i < lists.length - 1; i++) {
            res = merge2List(res, lists[i]);
        }

        return res;
    }

    public ListNode mergeKListV3(ListNode[] lists) {
        // Divide and conquer

        if (lists.length == 0 ) {
            return null;
        }
 
        while (lists.length > 1) {

            List<ListNode> lt = new ArrayList<>();

            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = ((i + 1) < lists.length) ? lists[i + 1] : null;
                lt.add(merge2List(l1, l2));
            }
            lists = lt.toArray(new ListNode[lt.size()]);

        }

        return lists[0];
    }

    public ListNode merge2List(ListNode l1, ListNode l2) {

        ListNode r = new ListNode(0);
        ListNode iter = r;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                iter.next = l1;
                l1 = l1.next;
            } else {
                iter.next = l2;
                l2 = l2.next;
            }

            iter = iter.next;
        }

        if (l1 == null) {
            iter.next = l2;
        } else {
            iter.next = l1;
        }

        return r.next;

    }

}
