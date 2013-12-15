package Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	private ArrayList<Vertex> vertexes = new ArrayList(); 
	private ArrayList<Edge> edges = new ArrayList();
    private ArrayList<Edge> outGoingEdges = new ArrayList<Edge>();

	
	public Graph (ArrayList<Vertex> Vertices, ArrayList<Edge> edges)
	{
		this.vertexes = Vertices;
		this.edges = edges;
	}
	
	
	
	
	public void graphParser() {
		
	}

	public void AddOutgoingEdge(Edge node) {
        this.outGoingEdges.add(node);
		}
/**
* 
* @return
*/
public ArrayList<Edge> getOutGoingEdges() {
        return outGoingEdges;
}

	public ArrayList<Vertex> getVertexes() {
		return vertexes;
	}



	public ArrayList<Edge> getEdges() {
		return edges;
	}


}
