package collectionframework;
import collectionframework.ICollection;
public abstract class CustomAbstractCollection<E> implements ICollection<E>{
	protected CustomAbstractCollection(){}

	public abstract int size();

	public boolean isEmpty(){
		return this.size()==0;
	}

	// yet to figure out since iterable and iterator is not learned.
	// ask them how to do this method
	public boolean contains(Object o){
		throw new UnsupportedOperationException();	
	}

	// this also has to deal with iterator 
	public Object[] toArray(){
		throw new UnsupportedOperationException();
	}
}