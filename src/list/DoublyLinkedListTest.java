package list;

import java.util.Arrays;

public class DoublyLinkedListTest {

	public static void main(String[] args) {
		List<Integer> list = new DoublyLinkedList<Integer>();
		
		//add연산
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(55);
		
		System.out.println("삭제된 원소는: "+list.remove(0));
		int count = list.size();
		System.out.println("리스트 크기: "+count);
//		
		//get 연산
		for(int i = 0 ; i < count ; ++i){
			System.out.println(i+"번째 항목 : "+list.get(i));
		}
		
//		foreach문 사용하기 위해 java.lang.iterable 인터페이스 구현해야함
//		for(Integer i : list){
//			System.out.println(list.get(i));
//		}
		
		System.out.println(Arrays.toString(list.toArray()));
		//list.removeAll();
	//	count = list.size();
		//System.out.println("리스트 크기: "+count);
	//	System.out.println(Arrays.toString(list.toArray()));
		
//		//exception test
//		try{
//			list.get(0); 
//		}catch(IndexOutOfBoundsException e){
//			e.printStackTrace();
//		}
	}

}
