package tree;

import java.util.Arrays;

import queue.Queue;
public class PriorityQueue<E> implements Queue<E> {
	//제네릭 데이터 배열
	private E[] arrayHeap = null;
	private int size; // 위치
	//compare하기 위한 Comparator객체
	private Comparator<E> comparator;

	//initialize
	public PriorityQueue(int capacity, Comparator<E> comparator) {
		this.size = 0;
		this.comparator = comparator;
		resize(capacity);
	}

	//resize array
	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity];
		for (int i = 0; i < size; i++) {
			temp[i] = arrayHeap[i];
		}
		arrayHeap = temp;
	}
	
	//add item
	public void offer(E item) {
		if (arrayHeap.length <= size) {
			resize(arrayHeap.length * 2);
		}
		int index = size + 1;
		while (index != 1) {
			//반복문은 최소한의 부모노드가 존재할때 들어온다.
			//자식index
			int parentIndex = index / 2;
			//부모노드와 넣으려는 item의 비교결과
			int result=comparator.compare(arrayHeap[parentIndex], item);
			//결과가 -1로 부모가 크다면 반복문 종료
			if(result<=0){
				break;
			}
			//그렇지 않다면 현재 새로만드려는 노드에 부모의 노드를 넣고
			arrayHeap[index] = arrayHeap[parentIndex];
			//인덱스값을 수정해준다
			index = parentIndex;
		}
		
		//현재 인덱스는 부모의 위치를 하고 있고 새로운 아이템은 부모의 위치에 바로 들어가게된다.
		arrayHeap[index] = item;
		size++;
	}

	public E poll() {
		if (0 == size) {
			throw new IndexOutOfBoundsException();
		}
		//root를 꺼내주기위함
		E data = arrayHeap[1];
		//마지막에 추가된 노드를 꺼내주기 위함
		E lastItem = arrayHeap[size];

		int parentIndex = 1;
		while (true) {
			//반복문을 통해서 root노드를 꺼내준후 재정렬 하기 위함
			//왼쪽자식 노드위치
			int leftchildIndex = parentIndex * 2;
			//왼쪽자식이 없다면 반복문 종료
			//왼쪽이 없으면 오른쪽도 없다.
			if (leftchildIndex > size) {
					break;
			}
			int childIndex = 0;
			//왼쪽노드의 인덱스(위치)와 현재 전체노드의 크기가 같은것은 오른쪽 자식이 없다는것
			if (leftchildIndex == size) {
				//왼쪽자식 위치를 넣어준다
				childIndex = leftchildIndex;
			} else {
				//그렇지 않다면 오른쪽 자식이 된다.
				int rightchildIndex = parentIndex * 2 + 1;
				//그리고 비교를 한다 왼쪽과 오른쪽
				int result = comparator.compare(arrayHeap[leftchildIndex], arrayHeap[rightchildIndex]);
				//자식 노드가 누가 될지 위치를 찾는다  
				childIndex = (result<=0)?leftchildIndex : rightchildIndex;
			}
			//-1이 나오면 반복문 나간다.
			int result = comparator.compare(lastItem, arrayHeap[childIndex]);
			if (result <= 0) {
				break;
			}
			//노드의 위치를 바꿔준다 처음 비교대상이었던 끝의 노드와 부모노드를
			arrayHeap[parentIndex] = lastItem;
			//부모와 자식의 인덱스도 바꿔준다.
			parentIndex = childIndex;
		}
		//반복문을 그냥 나왔을경우 정렬을 위함
		arrayHeap[parentIndex] = lastItem;
		//삭제된 노드 null처리
		arrayHeap[size--] = null;
		
		return data;
	}

	public E peek() {
		System.out.println(Arrays.toString(arrayHeap));
		return arrayHeap[1];
	}
}

// package tree;
//
// import java.util.Arrays;
//
// public class PriorityQueue {
//
// private String[] arrayHeap;
// private int size; // 위치
//
// public PriorityQueue(int capacity) {
// size = 0;
// resize(capacity);
// }
//
// private void resize(int capacity) {
// String[] temp = new String[capacity];
// for (int i = 0; i < size; i++) {
// temp[i] = arrayHeap[i];
// }
// arrayHeap = temp;
// }
//
// public void offer(String item) {
// if (arrayHeap.length <= size) {
// resize(arrayHeap.length * 2);
// }
// int index = size + 1;
//
// // root노드 다음으로 들어오는 반복문
// while (index != 1) {
// int parentIndex = index / 2;
// // 우선순위 algorithm
// // 문자열 길이를 비교하는데 음수값이냐 양수값이냐에 따라서 노드의 위치를 바꿔주어야 한다
// // 자식노드 값의 길이가 더 짧다면 break한다.
// if ((arrayHeap[parentIndex].length() - item.length()) <= 0) {
// break;
// }
// // 들어오게 될 새로운 노드는 반복문을 나가면 들어 갈 수 있기 때문에 그냥 넣어도 된다.
// arrayHeap[index] = arrayHeap[parentIndex];
// index = parentIndex;
// }
// // 우선순위에 의해 아이템이 들어갈 곳
// arrayHeap[index] = item;
// size++;
// }
//
// public String poll() {
// if(0==size){
// throw new IndexOutOfBoundsException();
// }
// String data = arrayHeap[1];
// String lastItem = arrayHeap[size];
//
// int parentIndex = 1;
// while (true) {
// int childIndex = 0;
// int leftchildIndex = parentIndex * 2;
// if (leftchildIndex > size) {
// // left노드 가 없다. 단노드이다.
// break;
// }
// if (leftchildIndex == size) {
// // right가 없는 단노드
// childIndex = leftchildIndex;
// } else {
// int rightchildIndex = parentIndex * 2 + 1;
//
// if (arrayHeap[leftchildIndex].length() - arrayHeap[rightchildIndex].length()
// <= 0) {
// childIndex=leftchildIndex;
// } else {
// childIndex = rightchildIndex;
// }
// }
// if(lastItem.length()-arrayHeap[childIndex].length() <= 0){
// break;
// }
// arrayHeap[parentIndex]=arrayHeap[childIndex];
// parentIndex=childIndex;
// }
// arrayHeap[parentIndex]=lastItem;
// arrayHeap[size]=null;
// size--;
// return data;
// }
//
// public String peek() {
// System.out.println(Arrays.toString(arrayHeap));
// return arrayHeap[1];
// }
// }
