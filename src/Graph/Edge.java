	package Graph;

public class Edge {
	
	private int id; 
	private final Vertex source;
	private final Vertex destination; 
	private int distance;
	
	public Edge(int ide, Vertex prev, Vertex next)
	{
		this.id = ide;
		this.source = prev;
		this.destination = next;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public Vertex getSource()
	{
		return this.source;
	}
	
	public Vertex getDestination()
	{
		return this.destination;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
