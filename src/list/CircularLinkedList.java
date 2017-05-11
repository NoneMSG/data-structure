package list;



public class CircularLinkedList<E> implements List<E> {
	private int size = 0;
	private Node<E> tail = null;
	private Node<E> pos =null;
	
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

		if (tail == null) {
			tail = newNode.next = newNode;
		} else {
			newNode.next = tail.next; // 의미적으로 tail.next는 head
			tail.next = newNode; // tail의 다음은 head입니다.
			tail = tail.next; // tail회전 시키기
		}
		size++;
	}

	@Override
	public void add(int index, E element) {
		if (size <= index) {
			throw new IndexOutOfBoundsException();
		}
		if(index==0){ //head부분;tail.next
			Node<E> newNode = new Node<E>(element);
			Node<E> x =tail.next; //처음 항목 위치 이녀석을 한칸 뒤로 밀어야된다.;
			tail.next=newNode;
			newNode.next = x;
			
			//System.out.println("head:"+ tail.next.data);
		}else if(index==size-1){//tail에 추가
			//add(element);
			//return;
			Node<E> newNode = new Node<E>(element);
			Node<E> x =tail.next; //처음 항목 위치 이녀석을 한칸 뒤로 밀어야된다.;
			for(int i = 0 ; i < index-1 ; i++){
				x=x.next;
			}
			newNode.next = tail; //새로삽입된 원소의 다음은 원래있던 원소인 tail 
			x.next=newNode;  //추가된곳이전의 녀석의 다음녀석은 새로삽입된 원소
		}else{ //그이외에 추가 (중간삽입)
			Node<E> newNode = new Node<E>(element);
			Node<E> x = tail.next; //head
			for(int i = 0 ; i < index ; i++){ //현재위치를 구하고
				x=x.next;
			}
			newNode.next = x; //삽입할 새로운 데이터의 next에 현재있던 원소의 위치를 넣어준다.
			//원래있던 원소의 이전의 자리를 찾기위해
			Node<E> y = tail.next;
			for(int i = 0 ; i < index-1; i++){ //받은 index보다 -1의 위치는 원래보다 앞의위치
				y=y.next;
			}
			y.next = newNode;//삽입된원소를 연결해준다.
			
		}
		size++;
	}

	@Override
	public E get(int index) {
		if (size <= index) {
			throw new IndexOutOfBoundsException();
		}

		Node<E> x = tail.next; // head
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
		if(index==0){//head삭제
			Node<E> x = tail.next ; //head의 위치
			tail.next = x.next; //head의 다음녀석을 연결해준다.
			x=null;//그리고 x는 없어진다.
		}else if(index==size-1){//tail삭제
			Node<E> tempHead = tail.next; //head의 위치
			//tail의 위치를 알기위해 index로 테일의 뒤에 녀석을 찾아낸다.
			Node<E> x= tail.next;//head
			for(int i = 0 ; i < index-1; ++i){
				x=x.next;
			}
			x.next =tempHead;
			tempHead=null;
//			System.out.println("tail-1:"+x.data);
//			System.out.println("tail.next:"+x.next.data);
		}else{
			//해당 인덱스의 앞자리 원소를 찾아야 해당인덱스를 지우고 해당인덱스의 뒤의 노드와 연결할 수 있다.
			Node<E> x = tail.next;
			for(int i = 0 ; i < index-1;++i){//해당인덱스-1 노드(prev)
				x=x.next;
			}
			
			Node<E> y = tail.next;
			for(int i = 0; i<index+1;++i){ //해당인덱스+1 노드(next)
				y=y.next;
			}
			x.next=y;
			
			System.out.println("next:"+tail.next.data);
		}
		
		size--;
		
		return null;
	}

	@Override
	public void removeAll() {
		Node<E> x = tail.next; // head부터 시작한다.
		while (x != tail) { // x(head)가 tail을 만날때까지 반복
			Node<E> next = x.next;
			x.next = null;
			x = next;
		}
		tail.next = null; // tail에 와서 head를 지워야한다.
		tail = null; // head까지 지운 후 자신도 null로 바꾸어 모두 지운다.

		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size];
		if (tail == null) {
			return arr;
		} else {
			int index = 0;
			Node<E> x = tail.next;
			while (true) {
				arr[index++] = x.data;
				x = x.next;

				if (x == tail.next) { // 다시 헤드로온다.
					break;
				}
			}
		}
		return arr;
	}
	
	public E next(){
		if(tail.next ==null){
			return null;
		}
		if(pos==null){
			pos=tail.next;
		}
		E data = pos.data;
		pos = pos.next;
		return data;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>(){
			private Node<E> pos=tail.next;
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

	

	
}
