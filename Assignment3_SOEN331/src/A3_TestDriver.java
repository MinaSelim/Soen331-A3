
public class A3_TestDriver {

	public static void main(String[] args) {
		Node a = new Node(1,"a");
		Node b = new Node(2,"b");
		Node c = new Node(14,"c");
		Node e = new Node(4,"d");
		Node f = new Node(12,"e");
		Node g = new Node(2,"f");
		Node h = new Node(15,"g");
		Node i = new Node(6,"h");
		Node j = new Node(3,"i");
		Node k = new Node(10,"j");
		PriorityQueue p = new PriorityQueue();
		System.out.println();
		System.out.println("Using isEmpty on an Empty Array");
		System.out.println(p.isEmpty());
		System.out.println();
		System.out.println("Inserting nodes into the priority queue");
		p.insert(a);
		p.insert(b);
		p.insert(c);
		p.insert(e);
		p.insert(f);
		p.insert(g);
		p.insert(h);
		p.insert(i);
		p.insert(j);
		p.insert(k);
		p.print();
		System.out.println();
		System.out.println("Removing a node from the priority queue");
		p.remove();
		p.print();

	}

}
