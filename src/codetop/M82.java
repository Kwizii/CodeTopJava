package codetop;

import structs.ListNode;

public class M82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            boolean flag = false;
            while (nxt != null && cur.val == nxt.val) {
                flag = true;
                nxt = nxt.next;
            }
            if (flag) {
                pre.next = nxt;
            } else {
                pre = cur;
            }
            cur = nxt;
        }
        return dummy.next;
    }
}
