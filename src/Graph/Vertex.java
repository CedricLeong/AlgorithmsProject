package Graph;

import java.util.ArrayList;

public class Vertex  implements Comparable<Vertex> {
	
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
	
	public void addOutgoingEdge(Vertex v) {
		Edge newEdge = new Edge(this, v);
		outgoingEdges.add(newEdge);
	}

	@Override
	public int compareTo(Vertex arg0) {
		// TODO Auto-generated method stub
		Integer distance1 = this.distance;
		Integer distance2 = arg0.getDistance();
		return distance1.compareTo(distance2);
	}
}
