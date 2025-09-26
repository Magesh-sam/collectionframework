package collectionframework;

public interface ICollection<E>{
	boolean add(E e);
	boolean addAll(ICollection<? extends E> c);
	void clear();
	boolean contains(Object o);
	boolean containsAll(ICollection<?> c);
	boolean isEmpty();
	boolean remove(Object o);
	boolean removeAll(ICollection<?> c);
	boolean retainAll(ICollection<?> c);
	int size();
	Object[] toArray();
	<T> T[] toArray(T[] a);

}