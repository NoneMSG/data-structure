package list;

public class LinkedList<E> implements List<E> {

	private Node<E> head;
	private int size;

	@Override
	public void add(E element) {
		final Node<E> newNode = new Node<E>(element);
		
		if (head == null) {
			head = newNode;
			//head = tail = newNode;
		} else {
			Node<E> x = head;
			while (x.next != null) {
				x = x.next;
			}
			//tail.next= newNode;
			//tail = newNode;
			x.next = newNode;
		}
		size++;
	}

	@Override
	public void add(int index, E element) {
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			Node<E> newNode = new Node<E>(element);
			//Node<E> temp = head;
			head = newNode;

			//newNode.next = temp;

		} else if (size == index) {
			add(element);
			return;
		} else {
			Node<E> x = head; // head는 현재위치
			for (int i = 0; i < index - 1; ++i) {
				x = x.next;
			}
			Node<E> newNode = new Node<E>(element, x.next);
			x.next = newNode;
		}
		size++;
	}

	@Override
	public E get(int index) {
		if (size <= index) {
			throw new IndexOutOfBoundsException();
		}
		// 시간복잡도 n
		Node<E> x = head;
		for (int i = 0; i < index; ++i) {
			x = x.next;
		}
		return x.data;
	}

	@Override
	public E remove(int index) {
		if (size <= index) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> temp=null;
		
//		E data =null;
//		if(0==index){
//			data = head.data;
//			head = head.next;
//		}else{//중간또는tail삭제
//			Node<E> x =head;
//			for(int i = 0 ; i < index -1; i++){
//				x=x.next;
//			}
//			data = x.next.data;
//			x.next = x.next.next;
//			if(x.next =null){
//				tail=x;
//			}
//		}
		
		if (index == size-1) {
			// 현재위치
			Node<E> x = head;
			for (int i = 0; i < index; ++i) {
				x = x.next;
			}
			temp = x;
			x = null;
			
		}else if(index == 0){ 
			Node<E> x = head;
			for (int i = 0; i < index+1; ++i) {
				x = x.next;
			}
			temp = head;
			head=x;
		}else {
			//다음위치
			Node<E> x = head;
			for(int i = 0 ; i < index; ++i){
				x=x.next;
			}
			temp = x;
			//System.out.println("x: "+x.data);
			
			//이전위치
			Node<E> y = head ; 
			for(int i = 0 ; i< index-1;++i){
				y=y.next;
			}
			//System.out.println("y: "+y.data);
			
			y.next = x.next; //현재의 이전과 이후의 요소 참조
			//현재 데이터 제거
			x=null;
		}

		size--;
		return temp.data;
		//return null;
	}

	@Override
	public void removeAll() {
		for (Node<E> x = head; x != null;) {
			Node<E> next = x.next;

			x.data = null;
			x.next = null;

			x = next;
		}
		head = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	// 내부클래스를 사용하면 바깥 클래스의 메소드를 쓸 수 있다
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
	public Object[] toArray() {
		Object[] arr = new Object[size];
		Node<E> x =head;
		int index = 0;
		while(x!=null){
			arr[index++] = x.data;
			x=x.next;
		}
		
		return arr;
	}

}
