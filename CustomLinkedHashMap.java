package collectionframework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class CustomLinkedHashMap<K, V> extends HashMap<K, V> {
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev, next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<K, Node<K, V>> map = new HashMap<>();
    private Node<K, V> head, tail;

    public V put(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }
        Node<K, V> newNode = new Node<K, V>(key, value);
        map.put(key, newNode);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        return null;
    }

    public V get(Object key) {
        Node<K, V> node = map.get(key);
        return node == null ? null : node.value;
    }

    public V getOrDefault(Object key, V defaultValue) {
        Node<K, V> node = map.get(key);
        return node == null ? defaultValue : node.value;
    }

    public V remove(Object key) {
        Node<K, V> node = map.remove(key);
        if (node == null) {
            return null;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        return node.value;

    }

    public Collection<V> values() {
        return super.values();
    }

    public Set<K> keySet() {
        return super.keySet();
    }

    public boolean containsValue(Object value) {
        return super.containsValue(value);
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    public void clear() {
        super.clear();
        head = tail = null;
    }

    public void print(){
        Node<K,V> curr = head;
        while (curr!=null) {
            System.out.println(curr.key.toString() + " -> " +curr.value.toString());
            curr = curr.next;
        }
    }
}
