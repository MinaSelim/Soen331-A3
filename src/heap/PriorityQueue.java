package heap;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class PriorityQueue 
{
	private Item[] heap ;
	private int size = 0;
	/*
	 * constructor that sets
	 */
	public PriorityQueue(int size) 
	{
		heap = new Item[size];
	}

	/*
	 * returns true if heap is empty
	 * 
	 */
	public boolean isEmpty()
	{
		return size==0;
	}
	/*
	 * returns number of elements in the heap
	 */
	public int size()
	{
		return size;
	}
	
	/*
	 * removes and returns the top element of the heap
	 */
	public String remove()
	{
		if(size==0)
			throw new NoSuchElementException();
		String toReturn = heap[0].obj;
		heap[0] = heap[--size];
		int current_index = 0;

		while(hasLeft(current_index) )
		{
			if(hasRight(current_index))
			{
				if(getLeft(current_index).key < heap[current_index].key)
				{
					if(getRight(current_index).key < getLeft(current_index).key)
					{
						swap(current_index,getRightIndex(current_index));
						current_index = getRightIndex(current_index);
					}
					else
					{
						swap(current_index, getLeftIndex(current_index));
						current_index = getLeftIndex(current_index);
					}
				}
				else if(getRight(current_index).key < heap[current_index].key)
				{
					swap(current_index, getRightIndex(current_index));
					current_index = getRightIndex(current_index);
				}
				else
					break;
			}
			else
			{
				if(getLeft(current_index).key < heap[current_index].key)
				{
					swap(current_index, getLeftIndex(current_index));
					current_index = getLeftIndex(current_index);
				}
				else
					break;

			}
		}

		return toReturn;
	}

	/*
	 * returns the root element of the heap
	 */
	public String min()
	{
		return heap[0].obj;
	}

	/*
	 * inserts and item into the heap (helper method)
	 */
	private void insert(Item a)
	{
		heap[size] = a;
		size++;
		int current_index = size-1;

		while(getParent(current_index).key > heap[current_index].key && current_index !=0)
		{
			swap(getParentIndex(current_index), current_index);
			current_index= getParentIndex(current_index);
		}

	}
	/*
	 * inserts a String onto the heap based on its key
	 */
	public void insert(int key, String a)
	{
		insert(new Item(a,key));
	}


	/*
	 * prints the heap	
	 */
	public void printHeap(PrintStream a)
	{
		int index = 0;
		int limit = 1;
		int tab = getHeight();
		while(index < size)
		{
			for(int z =index; index<limit && index !=size; index++)
			{

				for(int i = tab; i>0; i--)
					a.print("\t");
				a.print(heap[index].key);
			}
			a.println();
			tab--;
			limit= limit*2 +1;

		}

	}

	/*
	 * swap two items together on the array
	 */
	private void swap(int a, int b)
	{
		Item temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	/*
	 * returns the height of the heap
	 */
	public int getHeight()
	{
		return (int) ( Math.log(size)/Math.log(2) +1);
	}
	//gets left child item
	private Item getLeft(int i)
	{
		return heap[i*2+1];
	}
	//gets right child item
	private Item getRight(int i)
	{
		return heap[(i*2)+2];
	}
	//gets parent item
	private Item getParent(int i)
	{
		return heap[(i-1)/2];
	}
	//gets parent index
	private int getParentIndex(int i) 
	{
		return (i-1)/2;
	}
	//gets left index
	private int getLeftIndex(int i) 
	{
		return (i*2)+1;
	}
	//gets right index
	private int getRightIndex(int i) 
	{
		return (i*2)+2;
	}
	//returns true if node has a left child
	private boolean hasLeft(int i)
	{
		return (i*2)+1<size;
	}
	//returns true if node has a right child
	private boolean hasRight(int i)
	{
		return (i*2)+2<size;
	}

	//represents the item that needs to be added
	private class Item
	{
		private String obj;
		private int key;

		public Item(String obj, int key) {
			super();
			this.obj = obj;
			this.key = key;
		}


	}

}

