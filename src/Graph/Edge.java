	package Graph;

public class Edge {
	
	private final Vertex source;
	private final Vertex destination; 
	
	// An edge connects two nodes bi-directionally
	public Edge(Vertex prev, Vertex next)
	{
		this.source = prev;
		this.destination = next;
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
