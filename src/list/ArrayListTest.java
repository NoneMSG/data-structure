package list;

import java.util.Arrays;

public class ArrayListTest {
	public static void main(String args[]){
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(0);
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		

		for(int i = 0 ; i<list.size();++i){
			System.out.println(i+"___"+list.get(i));
		}
		//System.out.println( Arrays.toString(list.toArray()) );
		System.out.println("----------");
		list.add(1,1000);
		for(int i = 0 ; i<list.size();++i){
			System.out.println(i+"___"+list.get(i));
		}
		
		System.out.println("----------");
		
		System.out.println("removed : "+list.remove(1));
		for(int i = 0 ; i<list.size();++i){
			System.out.println(i+"___"+list.get(i));
		}
		//System.out.println(list.size());
//		//add연산
//		list.add(11);
//		list.add(22);
//		
//		
//		int count = list.size();
//		System.out.println("리스트 크기: "+count);
//		
//		//get 연산
//		for(int i = 0 ; i < count ; ++i){
//			System.out.println(i+"번째 항목 : "+list.get(i));
//		}
//		
//		list.removeAll();
//		count = list.size();
//		System.out.println("리스트 크기: "+count);
//		
//		//exception test
//		try{
//			list.get(0); //null이 나온다 이럴때 exception 처리를 해주는게 좋다.
//		}catch(IndexOutOfBoundsException e){
//			e.printStackTrace();
//		}
	}
}
