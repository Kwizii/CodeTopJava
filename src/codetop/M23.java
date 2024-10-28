package codetop;

import structs.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class M23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) pq.offer(list);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            cur.next = poll;
            cur = cur.next;
            if (poll.next != null) {
                pq.offer(poll.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode b = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode c = new ListNode(2, new ListNode(6));
        new M23().mergeKLists(new ListNode[]{a, b, c});
    }
}
