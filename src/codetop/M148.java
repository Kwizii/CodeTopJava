package codetop;

import structs.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

class M148 {
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode dummy = new ListNode(0);
        while (head != null) {
            pq.offer(head);
            head = head.next;
        }
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
}