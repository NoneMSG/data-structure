package list;


public class DoublyLinkedList<E> implements List<E> {
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

		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	

}
