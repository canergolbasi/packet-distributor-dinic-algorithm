
public class Edge {

	int destination;
	int capacity;	
	int backward; // the back of back means forward
	int reverseindex;
	
	public Edge(int destination, int capacity,int reverseindex) {
		
		this.destination = destination;
		this.capacity = capacity;
		backward=0;
		this.reverseindex=reverseindex;
	}
}
