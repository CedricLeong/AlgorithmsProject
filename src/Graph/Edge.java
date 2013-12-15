	package Graph;

public class Edge {
	
	private int id; 
	private final Vertex source;
	private final Vertex destination; 
	
	public Edge(Vertex prev, Vertex next)
	{
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
	
}
