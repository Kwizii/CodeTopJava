package codetop;

import structs.ListNode;

public class M92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode pre = dummy;
        int count = 0;
        int len = right - left + 1;
        while (count < left) {
            pre = cur;
            cur = cur.next;
            count++;
        }
        ListNode nextn = cur;
        ListNode pren = null;
        while (len-- != 0) {
            ListNode next = cur.next;
            cur.next = pren;
            pren = cur;
            cur = next;
        }
        pre.next = pren;
        nextn.next = cur;
        return dummy.next;
    }

    public static void main(String[] args) {
        new M92().reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4);
    }
}
