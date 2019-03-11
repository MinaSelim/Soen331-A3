package heap;

privileged public aspect InsertAspect 
{
	
	    pointcut callInsert(int key, String value, PriorityQueue queue) : 
	     call(void PriorityQueue.insert(int,String)) && args(key,value) && target(queue);
	    
	    private int PriorityQueue.insertFailures = 0;
	    
	    public int PriorityQueue.getInsertFailures()
	    {
	    	return this.insertFailures;
	    }
	 
	 
	    void around(int key, String value, PriorityQueue queue) : 
	    	callInsert(key, value, queue) 
	    {
	        if(queue.heap.length == queue.size)
	        {
	        	System.out.println("Heap is full, insert failed. this is failure number " + ++queue.insertFailures);
	        }
	        else
	        {
		        proceed(key, value, queue);
	        }
	    }
	 

}
