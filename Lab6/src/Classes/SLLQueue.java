package Classes;
import Interfaces.Queue;

/** 
   A partial implementation of the Queue using a singly linked list with references 
   to the first and to the last node.
**/
public class SLLQueue<E> implements Queue<E> {
      
    private SNode<E> first, last;   // references to first and last node
    private int size; 
    
    public SLLQueue() {           // initializes instance as empty queue
        first = last = null; 
        size = 0; 
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public E first() {
        if (isEmpty()) return null;
        return first.getElement(); 
    }
    public E dequeue() {
        if (isEmpty()) return null;        
        E etr = first.getElement(); 
		SNode<E> temp=((SNode<E>) first).getNext();

		first.clean();
		first=temp;
		
		size--;
		return etr;
    }
    public void enqueue(E e) {
    	SNode<E> ntr = new SNode<E>(e); 
		if (size == 0)
			first = ntr; 
		else 
			last.setNext(ntr); 
		last = ntr; 
		size++; 
    }
	
}
