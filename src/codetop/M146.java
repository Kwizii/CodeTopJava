package codetop;

import java.util.HashMap;
import java.util.Map;

class M146 {
    class DNode {
        public int key;
        public int value;
        public DNode prev, next;

        public DNode() {
        }

        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DNode(int key, int value, DNode prev, DNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    int cap;
    int size = 0;
    Map<Integer, DNode> map = new HashMap<>();
    DNode head = new DNode();
    DNode tail = new DNode();

    public M146(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DNode node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            size++;
            node = new DNode(key, value);
            addToHead(node);
            map.put(key, node);
            if (size > cap) {
                size--;
                DNode last = tail.prev;
                removeNode(last);
                map.remove(last.key);
            }
        }
    }

    public void addToHead(DNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(DNode node) {
        removeNode(node);
        addToHead(node);
    }


    public static void main(String[] args) {
        M146 o = new M146(1);
        o.get(6);
        o.get(8);
        o.put(12, 1);
        o.get(2);
        o.put(15, 11);
        o.put(5, 2);
        o.put(1, 15);
        o.put(4, 2);
        o.get(5);
        o.put(15, 15);
    }
}