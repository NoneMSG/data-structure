package list;

public class ArrayList<E> implements List<E> {
	
	private static final int INIT_CAPACITY = 10;
	private E[] data;
	private int size;
	
	@SuppressWarnings("unchecked")
	public ArrayList(){
		//java에서는 생성자에서 자료구조에 필요한 init을 해준다.
		size = 0;
		//generic은 데이터의 크기를 지정 불가능하기 때문에 object로 data를 동적생성 하고 다운캐스팅 해준다. 
		//data = (E[])new Object[INIT_CAPACITY]; 
		resize(); //메모리 공간을 만드는건 모두 resize를 통해서 하도록 한다면
	}
	
	//배열의 크기가 작다면 resizing을 해야하기 때문에 내부 함수로 만든다.
	private void resize(){
		int capacity= (data==null) ? INIT_CAPACITY : data.length*2;
		//한번에 메모리 공간을 늘리고 싶은만큼 임시로 할당.
		E[] temp = (E[])new Object[capacity];
		
		//현재 data 배열에 들어있는 값들을 temp로 옮기는 작업.
		for(int i = 0 ; i< size ; ++i){
			temp[i] = data[i];
		}
		//옮기는 작업을 마친 후 data에 temp를 참조시킨다.
		data=temp;
	}
	
	@Override
	public void add(E element) {
		if(data.length <= size ){
			resize();
		}
		data[size] = element;
		size++;
	}

	@Override
	public void add(int index, E element) {
		if(index >= size ){
			throw new IndexOutOfBoundsException();
		}
		//E dtemp = data[index];
		E[] tempArray = (E[])new Object[size+1];
		
		for(int i = 0 ; i < index; ++i){
			tempArray[i] = data[i];
		}
		
		tempArray[index] = element;
		
		for(int i = index+1 ; i <= size ; ++i){
			tempArray[i] = data[i-1];
		}
		size++;
		data=tempArray;
		
		//data[index]=element;
	}

	@Override
	public E get(int index) {
		if(index == size){
			throw new IndexOutOfBoundsException();
		}
		return data[index]; //시간복잡도 1
	}

	@Override
	public E remove(int index) {
		if(index >= size){
			throw new IndexOutOfBoundsException();
		}
		E temp = data[index];
		data[index]=null;

		for(int i = index ; i < size-index; ++i){
			//배열에서 삭제된 인덱스의 빈공간을 해당 인덱스로부터 뒤에있던 원소들을 끌어당기기 위함
			data[i] = data[i+1];
		}
		size--;
		return temp;
	}

	@Override
	public void removeAll() {
		//시간 복잡도 n
		for(int i = 0 ; i < size ; ++i){
			data[i] = null;
		}
		size = 0 ;
	}

	@Override
	public int size() {
		
		return size;
	}

}
