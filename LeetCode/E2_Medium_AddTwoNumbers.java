/**
 * E2_Medium_AddTwoNumbers
 * https://leetcode.com/problems/add-two-numbers/submissions/
 */
public class E2_Medium_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode act = head;

        int save = 0; // Divisor entero
        int x, y;

        while (l1 != null || l2 != null || save != 0) {

            x = (l1 != null) ? l1.val : 0;
            y = (l2 != null) ? l2.val : 0;
            int sum = x + y + save;

            act.next = new ListNode(sum % 10);
            act = act.next;

            save = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return head.next;

    }

    // Better Solution
    // Add Two Numbers (Java improved)
    public ListNode addTwoNumbers_(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }

}