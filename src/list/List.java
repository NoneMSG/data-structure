package list;
//인터페이스로 list를 ADT 구현 data type은 generic을 사용한다. (이는 java에 의존적인 프로그램)
public interface List<E> {
	void add(E element);
	void add(int index, E element);
	E get(int index);
	E remove(int index);
	void removeAll();
	int size();
	Object[] toArray(); //추가된기능
}
