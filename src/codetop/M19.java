package codetop;

import structs.ListNode;

class M19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while (n-- != 0) {
            fast = fast.next;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while (fast != null) {
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        pre.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}