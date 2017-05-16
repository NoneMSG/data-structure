package tree.test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityTest01 {

	public static void main(String[] args) {
		
			Queue<String> pq =			 
				new PriorityQueue<String>(
						10, //init capacity required
						new Comparator<String>(){// anonymous class
							//양수의 경우 부모 노드와 바꿔준다. (min heap)
							@Override
							public int compare(String arg0, String arg1) {
								//음수 정수중 반환하면 되기때문에 앞이 긴 문자면 정수 반대면 음수가 나온다.
								//0의 경우는 같다고 판단.
								return arg0.length()-arg1.length();
							} 
				}); 
			
		pq.offer("A");
		pq.offer("ABCD");
		pq.offer("ABC");
		pq.offer("ABCDEFGHI");
		pq.offer("ABCDE");
		
		//일반큐와 다르게, 우선순위를 지정해 주기 때문에 짧은 문자열 순서로 정렬이 되어 저장됨
		while(pq.isEmpty() == false){
			System.out.println(pq.poll());
		}
		
	}

}
