package collectionframework;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CustomArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;

    private static final Object[] EMPTY_ELEMENTDATA = new Object[0];
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = new Object[0];

    // Default constructor
    public CustomArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    // Constructor from collection
    public CustomArrayList(Collection<? extends E> c) {
        Object[] a = c.toArray();
        this.size = a.length;
        if (size != 0) {
            // if(c.getClass()==CustomArrayList.class){
            // @SuppressWarnings("unchecked")
            // CustomArrayList<E> src = (CustomArrayList<E>) c;
            // this.elementData = src.elementData;
            // }
            this.elementData = Arrays.copyOf(a, size, Object[].class);
        } else {
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    // Constructor with initial capacity
    public CustomArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[Math.max(initialCapacity, DEFAULT_CAPACITY)];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    // Add element at the end
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }

    // Add element at specific index
    public void add(int index, E e) {

        rangeCheckForAdd(index);
        ensureCapacity(size + 1);

        // shifting ele from i to i+1 and replacing the duplicate ele
        for (int i = size - 1; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }

        elementData[index] = e;
        size++;
    }

    // Get element
    @SuppressWarnings("unchecked")
    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    // Set element
    @SuppressWarnings("unchecked")
    public E set(int index, E e) {
        rangeCheck(index);
        E old = (E) elementData[index];
        elementData[index] = e;
        return old;
    }

    // Remove element at index
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        rangeCheck(index);
        E old = (E) elementData[index];
        for (int i = index; i < elementData.length - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[--size] = null;
        return old;
    }

    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    // Clear list
    public void clear() {
        Arrays.fill(this.elementData, 0, size, null);
        size = 0;
    }

    // Size and empty checks
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // first occurance
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {

            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;

    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    // last occu
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = elementData.length - 1; i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {

            for (int i = elementData.length - 1; i >= 0; i--) {
                if (elementData[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Object[] toArray() {
        return Arrays.copyOf(this.elementData, this.size);
    }

    // converting to given type array
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < this.size) {
            return Arrays.copyOf(elementData, this.size, (Class<? extends T[]>) a.getClass());
        } else {

            for (int i = 0; i < this.size; i++) {
                if (a.getClass().getComponentType().isInstance(elementData[i])) {
                    a[i] = (T) elementData[i];
                } else {
                    throw new ArrayStoreException("Element at index " + i + " is not of type "
                            + a.getClass().getComponentType().getName());
                }
            }
            if (a.length > this.size) {
                // to indicate the end of an array.
                a[this.size] = null;
            }
        }
        return a;
    }

    // toIndex exclusive so upto toIndex
    @SuppressWarnings("unchecked")
    public CustomArrayList<E> subList(int fromIndex, int toIndex) {

        CustomArrayList<E> list = new CustomArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            list.add((E) this.elementData[i]);
        }
        return list;
    }

    // grow upto min capvity
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length) {
            grow(minCapacity);
        }
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = this.elementData.length;
        if (oldCapacity <= 0 && this.elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return this.elementData = new Object[Math.max(minCapacity, DEFAULT_CAPACITY)];
        } else {
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            this.elementData = Arrays.copyOf(elementData, newCapacity);
            return elementData;
        }
    }

    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < this.size(); i++) {
            sb.append(this.elementData[i]);
            if (i != this.size() - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
