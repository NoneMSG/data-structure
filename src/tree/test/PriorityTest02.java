package tree.test;

import queue.Queue;
import tree.PriorityQueue;
import tree.Comparator;
public class PriorityTest02 {

	public static void main(String[] args) {

		Queue<String> pq = new PriorityQueue<String>(10, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
									
		

		pq.offer("A");
		pq.peek();
		
		pq.offer("ABCD");
		pq.peek();
		
		pq.offer("ABC");
		pq.peek();
		
		pq.offer("ABCDEFGHI");
		pq.peek();
		
		pq.offer("ABCDE");
		pq.peek();
		
		
		System.out.println(pq.poll());
		pq.peek();
		System.out.println(pq.poll());
		pq.peek();
		System.out.println(pq.poll());
		pq.peek();
		System.out.println(pq.poll());
		pq.peek();
		System.out.println(pq.poll());
		pq.peek();
	}

}


//package tree.test;
//
//import tree.PriorityQueue;
//
//public class PriorityTest02 {
//
//	public static void main(String[] args) {
//
//		PriorityQueue pq = new PriorityQueue(10);
//
//		pq.offer("A");
//		pq.peek();
//		
//		pq.offer("ABCD");
//		pq.peek();
//		
//		pq.offer("ABC");
//		pq.peek();
//		
//		pq.offer("ABCDEFGHI");
//		pq.peek();
//		
//		pq.offer("ABCDE");
//		pq.peek();
//		
//		
//		System.out.println(pq.poll());
//		pq.peek();
//		System.out.println(pq.poll());
//		pq.peek();
//		System.out.println(pq.poll());
//		pq.peek();
//		System.out.println(pq.poll());
//		pq.peek();
//		System.out.println(pq.poll());
//		pq.peek();
//		pq.poll();
//	}
//
//}
