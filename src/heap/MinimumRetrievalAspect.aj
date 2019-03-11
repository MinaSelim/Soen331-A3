package heap;

public privileged aspect MinimumRetrievalAspect {
		
		pointcut callMin(PriorityQueue queue) : 
		     (call(String PriorityQueue.min()) ||call(String PriorityQueue.remove())) && target(queue);
			 
		  String around(PriorityQueue queue) : 
			  callMin(queue) {
			  if(queue.size() == 0)
			  {
				  System.out.println("Error: Priority queue is empty, returning null");
				  return null;
			  }
			  
			  return proceed(queue);
		  }
}
