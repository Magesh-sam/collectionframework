package collectionframework;

import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public CustomLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public boolean add(T data) {
        this.addLast(data);
        return true;
    }

    public void add(int index, T data) {
        checkIndexForAdd(index);

        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            Node<T> newNode = new Node<>(data);
            newNode.next = current;
            newNode.prev = current.prev;

            if (current.prev != null) {
                current.prev.next = newNode;
            }
            current.prev = newNode;

            size++;
        }
    }

    public T remove() {
        return removeFirst();
    }

    public T remove(int index) {
        checkIndex();

        if (index == 0) {
            return removeFirst();
        }

        else if (index == size - 1) {
            return removeLast();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            T data = current.data;
            Node<T> prevNode = current.prev;
            Node<T> nextNode = current.next;

            if (prevNode != null) {
                prevNode.next = nextNode;
            }
            if (nextNode != null) {
                nextNode.prev = prevNode;
            }

            if (current == head) {
                head = nextNode;
            }
            if (current == tail) {
                tail = prevNode;
            }

            current.prev = null;
            current.next = null;

            size--;
            return data;
        }

    }

    public T removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("List is empty");
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("List is empty");
        T data = tail.data;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return data;
    }

    public T getFirst() {
        if (isEmpty())
            throw new NoSuchElementException("List is empty");
        return head.data;
    }

    public T getLast() {
        if (isEmpty())
            throw new NoSuchElementException("List is empty");
        return tail.data;
    }

    public T get(int index) {
        checkIcheckIndex(index);
        ndcheckIndex(index);
        ex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public int indexOf(Object o) {
        int index = 0;
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(o, current.data))
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        int index = size - 1;
        Node<T> current = tail;
        while (current != null) {
            if (Objects.equals(o, current.data))
                return index;
            current = current.prev;
            index--;
        }
        return -1;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    public <E> E[] toArray(E[] a) {
        if (a.length < size) {
            @SuppressWarnings("unchecked")
            E[] newArr = (E[]) new Object[size];
            a = newArr;
        }
        Node<T> current = head;
        int i = 0;
        while (current != null) {
            @SuppressWarnings("unchecked")
            E element = (E) current.data;
            a[i++] = element;
            current = current.next;
        }
        if (a.length > size)
            a[size] = null;
        return a;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null)
                sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
