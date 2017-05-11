package list;

public class CircularLinkedList<E> implements List<E> {
	private int size = 0;
	private Node<E> tail =null;
	
	private static class Node<E> {
		private Node<E> next;
		private E data;

		private Node(E element) {
			this.data = element;
			this.next = null;
		}

		private Node(E element, Node<E> next) {
			data = element;
			this.next = next;
		}
	}
	
	@Override
	public void add(E element) {
		final Node<E> newNode = new Node<E>(element);
		
		if(tail==null){
			tail = newNode.next = newNode;
		}else{
			newNode.next = tail.next; //의미적으로 tail.next는 head
			tail.next = newNode; //tail의 다음은 head입니다.
			tail = tail.next; //tail회전 시키기
		}
		size++;
	}

	@Override
	public void add(int index, E element) {

	}

	@Override
	public E get(int index) {
		if(size <= index){
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> x = tail.next ; //head 
		for(int i = 0 ; i < index ; ++i){
			x=x.next;
		}
		
		return x.data;
	}

	@Override
	public E remove(int index) {
		return null;
	}

	@Override
	public void removeAll() {
		Node<E> x = tail.next; //head부터 시작한다.
		while(x!=tail){ //x(head)가 tail을 만날때까지 반복
			Node<E> next = x.next;
			x.next=null;
			x=next;
		}
		tail.next = null; //tail에 와서 head를 지워야한다.
		tail = null; //head까지 지운 후 자신도 null로 바꾸어 모두 지운다.
		
		size=0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size];
		if(tail==null){
			return arr;
		}else{
			int index = 0;
			Node<E> x = tail.next;
			while(true){
				arr[index++]=x.data;
				x=x.next;
				
				if(x==tail.next){ //다시 헤드로온다.
					break;
				}
			}
		}
		return arr;
	}

}
