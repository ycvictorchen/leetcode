public class LRUCache {
    int size;
    int capacity;
    DoublyLinkedNode head;
    DoublyLinkedNode tail;
    java.util.Map<Integer, DoublyLinkedNode> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new java.util.HashMap<Integer, DoublyLinkedNode>();
    }
    public int get(int key) {
        if (this.map.containsKey(key)) {
            DoublyLinkedNode node = this.map.get(key);
            this.moveToHead(node);
            return node.value;
        }
        return -1;
    }
    public void set(int key, int value) {
        if (this.map.containsKey(key)) {
            DoublyLinkedNode node = this.map.get(key);
            node.value = value;
            this.moveToHead(node);
        }
        else if (this.capacity > 0) {
            DoublyLinkedNode node = new DoublyLinkedNode(key, value);
            this.map.put(key, node);
            if (this.size < this.capacity) {
                node.next = this.head;
                if (this.head == null) {
                    this.tail = node;
                }
                else {
                    this.head.prev = node;
                }
                this.head = node;
                this.size++;
            }
            else {
                node.next = this.head;
                this.head.prev = node;
                this.head = node;
                this.map.remove(this.tail.key);
                this.tail = this.tail.prev;
                this.tail.next = null;
            }
        }
    }
    private void moveToHead(DoublyLinkedNode node) {
        if (node == null || node == this.head) {
            return;
        }
        node.prev.next = node.next;
        if (node.next == null) {
            this.tail = node.prev;
        }
        else {
            node.next.prev = node.prev;
        }
        this.head.prev = node;
        node.next = this.head;
        node.prev = null;
        this.head = node;
    }
}
class DoublyLinkedNode {
    int key;
    int value;
    DoublyLinkedNode prev;
    DoublyLinkedNode next;
    DoublyLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}