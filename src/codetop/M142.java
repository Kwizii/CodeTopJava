package codetop;

import structs.ListNode;

public class M142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head, ans = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (ans != slow) {
                    ans = ans.next;
                    slow = slow.next;
                }
                return ans;
            }
        }
        return null;
    }
}
