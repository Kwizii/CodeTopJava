package codetop;

import structs.ListNode;

class M2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur1 = l1, cur2 = l2, cur3 = dummy;
        while (cur1 != null || cur2 != null || carry != 0) {
            int val1 = cur1 == null ? 0 : cur1.val;
            int val2 = cur2 == null ? 0 : cur2.val;
            int val = val1 + val2 + carry;
            carry = val / 10;
            val %= 10;
            cur3.next = new ListNode(val);
            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
            cur3 = cur3.next;
        }
        return dummy.next;
    }
}