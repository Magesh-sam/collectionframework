package collectionframework;

import java.util.HashMap;
import java.util.Collection;

public class CustomHashSet<E> {
    private static final Object DUMMY = new Object();
    private HashMap<E, Object> map;

    public CustomHashSet() {
        map = new HashMap<>();
    }

    public CustomHashSet(int initialCapacity) {
        map = new HashMap<>(initialCapacity);
    }

    public CustomHashSet(int initialCapacity, float loadFactor) {
        map = new HashMap<>(initialCapacity, loadFactor);
    }

    public CustomHashSet(Collection<? extends E> collection) {
        map = new HashMap<>(collection.size());
        addAll(collection);
    }

    public boolean add(E element) {
        return map.put(element, DUMMY) == null;
    }

    public boolean remove(Object element) {
        return map.remove(element) != null;
    }

    public boolean contains(Object element) {
        return map.containsKey(element);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public void clear() {
        map.clear();
    }

    public boolean addAll(Collection<? extends E> collection) {
        boolean modified = false;
        for (E element : collection) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

}