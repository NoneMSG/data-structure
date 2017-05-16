package tree.test;

import tree.PriorityQueue;

public class PriorityTest02 {

	public static void main(String[] args) {

		PriorityQueue pq = new PriorityQueue(10);

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
		pq.poll();
	}

}
