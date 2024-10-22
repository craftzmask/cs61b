package deque;

public class ArrayDeque<T> {
    T[] items;
    int size;
    int nextFirst;
    int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }

        if (nextFirst == -1) {
            nextFirst = items.length - 1;
        }

        items[nextFirst--] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }

        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int index = nextFirst + 1;
        for (int i = 0; i < size; i++) {
            System.out.println(items[index]);
            index = (index + 1) % items.length;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        if (size >= 16 && size * 4 < items.length) {
            resize(items.length / 4);
        }

        nextFirst = (nextFirst + 1) % items.length;
        T item = items[nextFirst];
        items[nextFirst] = null;
        size--;

        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        if (size >= 16 && size * 4 < items.length) {
            resize(items.length / 4);
        }

        if (nextLast - 1 < 0) {
            nextLast = items.length - 1;
        }

        T item = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast--;
        size--;

        return item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[(nextFirst + 1 + index) % items.length];
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            nextFirst = (nextFirst + 1) % items.length;
            newItems[i] = items[nextFirst];
        }
        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }
}
