import java.util.Random;

import heap.PriorityQueue;

public class A3_TestDriver {

	public static void main(String[] args) {
		Random random = new Random();
		random.setSeed(3948902489032L);
		PriorityQueue queue = new PriorityQueue(10);
		
		System.out.println("calling min : " + queue.min());
		System.out.println("calling remove : " + queue.remove());

		for(Integer i = 0; i<15; i++) //populate the queue
		{
			queue.insert(random.nextInt(200), i.toString());
		}
		
		queue.printHeap(System.out); // Prints the keys in the heap in a tree-like format 
		
		System.out.println("calling min : " + queue.min());

		for(Integer i = 0; i<15; i++) //empty the queue
		{
			String item = queue.remove();
			System.out.println("removed item: " + item); //reminder that the items are just the counters from 1-10
		}
	}

}