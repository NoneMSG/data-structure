package tree;

import java.util.Arrays;

public class PriorityQueue {

	private String[] arrayHeap;
	private int size; // 위치

	public PriorityQueue(int capacity) {
		size = 0;
		resize(capacity);
	}

	private void resize(int capacity) {
		String[] temp = new String[capacity];
		for (int i = 0; i < size; i++) {
			temp[i] = arrayHeap[i];
		}
		arrayHeap = temp;
	}

	public void offer(String item) {
		if (arrayHeap.length <= size) {
			resize(arrayHeap.length * 2);
		}
		int index = size + 1;

		// root노드 다음으로 들어오는 반복문
		while (index != 1) {
			int parentIndex = index / 2;
			// 우선순위 algorithm
			// 문자열 길이를 비교하는데 음수값이냐 양수값이냐에 따라서 노드의 위치를 바꿔주어야 한다
			// 자식노드 값의 길이가 더 짧다면 break한다.
			if ((arrayHeap[parentIndex].length() - item.length()) <= 0) {
				break;
			}
			// 들어오게 될 새로운 노드는 반복문을 나가면 들어 갈 수 있기 때문에 그냥 넣어도 된다.
			arrayHeap[index] = arrayHeap[parentIndex];
			index = parentIndex;
		}
		// 우선순위에 의해 아이템이 들어갈 곳
		arrayHeap[index] = item;
		size++;
	}

	public String poll() {
		if(0==size){
			throw new IndexOutOfBoundsException();
		}
		String data = arrayHeap[1];
		String lastItem = arrayHeap[size];

		int parentIndex = 1;
		while (true) {
			int childIndex = 0;
			int leftchildIndex = parentIndex * 2;
			if (leftchildIndex > size) {
				// left노드 가 없다. 단노드이다.
				break;
			}
			if (leftchildIndex == size) {
				// right가 없는 단노드
				childIndex = leftchildIndex;
			} else {
				int rightchildIndex = parentIndex * 2 + 1;

				if (arrayHeap[leftchildIndex].length() - arrayHeap[rightchildIndex].length() <= 0) {
					childIndex=leftchildIndex;
				} else {
					childIndex = rightchildIndex;
				}
			}
			if(lastItem.length()-arrayHeap[childIndex].length() <= 0){
				break;
			}
			arrayHeap[parentIndex]=arrayHeap[childIndex];
			parentIndex=childIndex;
		}
		arrayHeap[parentIndex]=lastItem;
		arrayHeap[size]=null;
		size--;
		return data;
	}

	public String peek() {
		System.out.println(Arrays.toString(arrayHeap));
		return arrayHeap[1];
	}
}
