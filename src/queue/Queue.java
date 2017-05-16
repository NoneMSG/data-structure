package queue;

public interface Queue<E>{
	void offer(E item);
	E poll(); //항목 제거하면서 반환
	E peek(); //제거 없이 데이터 반환
}
