package deque;

public class LinkedListDeque<T> {
    public class Node {
        T item;
        Node prev;
        Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    Node sentinel;
    int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (Node p = sentinel.next; p != sentinel; p = p.next) {
            System.out.println(p.item);
        }
    }

    public T removeFirst() {
        if (size > 0) {
            Node node = sentinel.next;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size--;
            return node.item;
        }
        return null;
    }

    public T removeLast() {
        if (size > 0) {
            Node node = sentinel.prev;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size--;
            return node.item;
        }
        return null;
    }

    public T get(int index) {
        Node p = sentinel.next;
        while (p != sentinel && index > 0) {
            p = p.next;
            index--;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getHelper(sentinel.next, index);
    }

    private T getHelper(Node p, int index) {
        if (index == 0) {
            return p.item;
        }
        return getHelper(p.next, index - 1);
    }
}
