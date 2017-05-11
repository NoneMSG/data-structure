package list;

public class LinkedListTest {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		
		//add연산
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(55);
		list.add(4,1000);
		
		//System.out.println("removed ele:"+list.remove(1));
		
		int count = list.size();
//		System.out.println("리스트 크기: "+count);
//		
		//get 연산
		for(int i = 0 ; i < count ; ++i){
			System.out.println(i+"번째 항목 : "+list.get(i));
		}
//		
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
