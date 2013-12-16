package Graph;

import java.util.ArrayList;

public class Vertex  implements Comparable<Vertex> {
	
	public int id; // ID for node
	public int distance = 999999; // Set distance to infinity
	private ArrayList<Edge> outgoingEdges = new ArrayList<Edge>();
	public  boolean visited = false;

	
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

	// Get the nodes connected
	public ArrayList<Edge> getOutgoingEdges() {
		return outgoingEdges;
	}
	
	// Adds an connected vertex to the vertex
	public void addOutgoingEdge(Vertex v) {
		Edge newEdge = new Edge(this, v);
		outgoingEdges.add(newEdge);
	}

	// Make the vertex object comparable to each other so they can be used in a heap
	@Override
	public int compareTo(Vertex arg0) {
		// TODO Auto-generated method stub
		Integer distance1 = this.distance;
		Integer distance2 = arg0.getDistance();
		return distance1.compareTo(distance2);
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
