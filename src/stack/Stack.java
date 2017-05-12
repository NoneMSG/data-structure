package stack;

public class Stack<E> extends ArrayList<E> {
	
	public void push(E item){
		super.add(item);
	}
	
	public E pop() throws StackException{
		if(isEmpty()){
			throw new StackException("stack is empty");
		}
		return remove(size()-1);
	}
	
	public E peek(){
		return get(size()-1);		
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
}
