

public class PriorityQueue 
{
Node[] heap;
int size;
public PriorityQueue() 
{
	size=0;
	heap=new Node[20];
}
public void swap(Node n1, Node n2)
{
	int temp1=n1.getKey();
	String temp2=n1.getValue();
	n1.setKey(n2.getKey());
	n1.setValue(n2.getValue());
	n2.setKey(temp1);
	n2.setValue(temp2);
}
public void insert(Node n)
{
	if(isEmpty())
	{
		size=1;
		heap[size]=n;
		return;
	}
	else if(size+1==heap.length-1)
	{
		Node[] temp = new Node[2*size];
		for(int i=1; i<=size; i++)
		{
			swap(heap[i],temp[i]);
		}
		heap=temp;
	}
	size++;
	heap[size]=n;
	for(int i=size; i>1; i=i/2)
	{
		if(heap[i].getKey()<heap[i/2].getKey())
		{
			swap(heap[i],heap[i/2]);
		}
	}
	
}

public Node remove()
{
	if(!isEmpty())
		{
		Node temp = heap[1];
		swap(heap[1],heap[size]);
		heap[size]=null;
		size--;
		boolean add = false;
		for(int i=size-1; i>1; i=i/2)
		{
			if(add=true)
			{
				i++;
				add=false;
			}
			if(heap[i].getKey()<heap[i/2].getKey())
			{
				swap(heap[i],heap[i/2]);
			}
			if(i!=size && heap[i+1].getKey()<heap[i/2].getKey()&& heap[i+1].getKey()<heap[i].getKey())
			{
				swap(heap[i],heap[i/2+1]);
				add=true;
			}
		}	
		return temp;
		}	
	else
		return null;
}

public boolean isEmpty()
{
	if(heap[1]==null)
		return true;
	else
		return false;
}

public int size()
{
	return size;
}
public void print()
{
	for(int i=1; i<=size; i++)
	{
		System.out.println(heap[i].toString());
	}
}
public Node min()
{
	return heap[1];
}
}