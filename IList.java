package collectionframework;
import collectionframework.ICollection;

public interface IList<E> extends ICollection<E>{
	boolean add(E e);
	void add(int index, E e);
	boolean addAll(ICollection<? extends E> c);
	boolean addAll(int index, ICollection<? extends E> c);

	void clear();
	// boolean contains(Object o);
	// boolean containsAll(ICollection<?> c);
	E get(int index);
	int indexOf(Object o);
	boolean isEmpty();
	int lastIndexOf(Object o);
	boolean remove(int index);
	boolean remove(Object o);
	boolean removeAll(ICollection<?> c);
	boolean retainAll(ICollection<?> c);
	E set(int index, E e);
	int size();
	IList<E> subList(int fromIndex, int toIndex);
	Object[] toArray();
	<T> T[] toArray(T[] a);

}