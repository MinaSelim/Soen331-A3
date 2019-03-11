import java.util.Random;

import heap.PriorityQueue;

public class A3_TestDriver {

	public static void main(String[] args) {
		Random random = new Random();
		random.setSeed(3948902489032L);
		PriorityQueue queue = new PriorityQueue(10);
		
		queue.min();
		queue.remove();

		for(Integer i = 0; i<15; i++) //populate the queue
		{
			queue.insert(random.nextInt(200), i.toString());
		}
		queue.printHeap(System.out); 
		
		System.out.println("calling min : " + queue.min());

	}

}