package codetop;

import structs.ListNode;

class H25 {
    public ListNode reverseK(ListNode node, int k) {
        ListNode pre = null;
        ListNode cur = node;
        int cnt = 0;
        while (cur != null && cnt++ < k) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode pre = dummy, next;
        while (true) {
            int cnt = 0;
            while (cur != null && cnt++ < k) {
                cur = cur.next;
            }
            if (cur == null) break;
            next = cur.next;
            ListNode npre = pre.next;
            pre.next = reverseK(npre, k);
            npre.next = next;
            pre = npre;
            cur = npre;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        new H25().reverseKGroup(node, 2);
    }
}