package queue;


public class DoublyLinkedList<E> implements List<E>,Queue<E> {
	private int size = 0;
	private Node<E> head;
	private Node<E> tail;

	@Override
	public void add(E element) {
		final Node<E> newNode = new Node<E>(element);

		if (head == null) {
			head = tail = newNode; // 아무것도 없을때 head, tail 모두 null
		} else {
			tail.next = newNode; // 1개 이상이 있을때 tail다음은 새로운 원소
			newNode.prev = tail; // 현재의 이전은 tail
			tail = newNode; // tail은 현재를 가리킨다.
		}
		size++;
	}

	@Override
	public void add(int index, E element) {
		if (size < index) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0){//head부분 추가
			Node<E> newNode = new Node<E>(element); //새로운 노드
			Node<E> x= head; //head
			head = newNode; // head의 위치에 새로운 노드 추가
			newNode.next=x; //새로운노드의 다음노드는 이전의 head
			head.prev = newNode;
			//System.out.println("head prev:"+head.prev.data);
		}else if(index==size){
			add(element);return;
			
		}else{
			Node<E> newNode = new Node<E>(element);
			//현재위치 찾기
			Node<E> x= head;
			for(int i = 0 ; i < index ; ++i){
				x=x.next;
			}
			Node<E> y= head; //새로추가될 노드의 prev노드 위치
			for(int i = 0 ; i < index-1 ; ++i){
				y=y.next;
			}
			
			newNode.prev = y ; //새로 삽입될 데이터에 이전의 노드의 prev 넣어준다.
			newNode.next = x; // 새로운 노드의 다음은 이전에 있던 노드의 위치
			x.prev = newNode; // 이전에 있던 노드의 prev는 추가된노드
			y.next = newNode; // 이전에 있던 노드의 prev의 다음 노드는 새로운 노드.
			
		}
		
		size++;
	}

	@Override
	public E get(int index) {
		if (size <= index) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> x = head;
		for (int i = 0; i < index; ++i) {
			x = x.next;
		}
		return x.data;
	}

	@Override
	public E remove(int index) {
		if (size < index) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> returnVal = null;
		if(index == 0){//head 삭제
			Node<E> x = head;
			returnVal = x;
			head = x.next;
			x=null;
			//head.prev=null;
			
		}else if(index==size-1){
			Node<E> x = tail;
			returnVal = x;
			tail = x.prev;
			x=null;
			tail.next=null;
		}else{
			
			//현재위치 찾기
			Node<E> x= head; //현재위치보다 앞의 노드
			for(int i = 0 ; i < index+1 ; ++i){
				x=x.next;
			}
			returnVal = x.prev;
			//System.out.println("현재위치:"+x.prev.data);
			
			Node<E> y= head; //현재위치보다 뒤의 노드
			for(int i = 0 ; i < index-1 ; ++i){
				y=y.next;
			}
			//뒤의 노드는 앞의 노드를 가리키고 앞의노드는 뒤의 노드를 가리킨다.
			x.prev = y;
			y.next = x;
			
		}
		size--;
		return returnVal.data;
	}

	@Override
	public void removeAll() {
		Node<E> x = head; // 현재위치
		while (x != null) { // null까지 반복
			Node<E> next = x.next; // next에 현재위치의 next를 넣어놓는다.
			x.prev = null; // 현재위치의 prev를 먼저 삭제
			x.next = null; // 다음 노드의 next를 삭제
			x = next;
		}
		tail = null; // 맨뒤 삭제
		head = null; // 맨앞 삭제
		size = 0; // 사이즈 0
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size];
		Node<E> x = head;
		int index = 0;
		while (x != null) {
			arr[index++] = x.data;
			x = x.next;
			
		}
		return arr;
	}

	private static class Node<E> {
		private Node<E> next;
		private Node<E> prev;
		private E data;

		private Node(E element) {
			this.data = element;
			this.next = null;
			this.prev = null;
		}

		// private Node(E element, Node<E> next, Node<E> prev) {
		// data = element;
		// this.next = next;
		// }
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>(){
			private Node<E> pos=head;
			private int index=0;

			@Override
			public boolean hasNext() {
				
				return index<size;
			}

			@Override
			public E next() {
				E data = pos.data;
				pos= pos.next;
				index++;
				return data;
			}
		};
	}

	@Override
	public void offer(E item) {
		add(item);
	}

	@Override
	public E poll() {
		if(head ==null){
			return null;
		}
		E data = head.data;
		head=head.next;
		if(head!=null){
			head.prev=null;
		}
		return data;
	}

	@Override
	public E peek() {
		if(head==null){
			return null;
		}
		return head.data;
	}

	

}
