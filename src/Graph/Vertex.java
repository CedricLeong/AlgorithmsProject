package Graph;

import java.util.ArrayList;

public class Vertex {
	
	public int id;
	public int distance = 999999; 
	private ArrayList<Edge> outgoingEdges = new ArrayList<Edge>();

	
	public Vertex(int idv)
	{
		this.id = idv;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public ArrayList<Edge> getOutgoingEdges() {
		return outgoingEdges;
	}
	
	public ArrayList<Edge> getNextOutgoingEdges() {
		return outgoingEdges;
	}

	public void addOutgoingEdges(Vertex outgoingEdge) {
		this.outgoingEdges.addAll( outgoingEdges);
	}
	
}
