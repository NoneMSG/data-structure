package list;

import java.util.Arrays;

public class CircularLinkedListTest {

	public static void main(String[] args) {
		List<Integer> list = new CircularLinkedList<Integer>();
		
		
		//add연산
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(55);
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			int i = it.next(); //auto unboxing
			System.out.println("====>"+i);
		}
		
		for(int i = 0 ; i<list.size();++i)
		System.out.println(((CircularLinkedList<Integer>) list).next());
		
		
//		//list.add(4,66);
//		list.remove(2);
//		int count = list.size();
//		System.out.println("리스트 크기: "+count);
//		
//		//get 연산
//		for(int i = 0 ; i < count ; ++i){
//			System.out.println(i+"번째 항목 : "+list.get(i));
//		}
		System.out.println(Arrays.toString(list.toArray()));
//		list.removeAll();
//		count = list.size();
//		System.out.println("리스트 크기: "+count);
//		
//		//exception test
//		try{
//			list.get(0); 
//		}catch(IndexOutOfBoundsException e){
//			e.printStackTrace();
//		}
	}

}
