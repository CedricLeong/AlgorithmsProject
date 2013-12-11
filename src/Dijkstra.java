

import java.util.*;

import Graph.*;

public class Dijkstra {	  
	  
	private Graph graph;

	private PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
	
    public Dijkstra (Graph g){
            this.graph  = g;
            this.pQueue.addAll(this.graph.getVertexes());

    }
    /**
    * Actual algorithm
    */
    public void execute(){
            while (!pQueue.isEmpty()){
                    Vertex n = pQueue.remove();
                    for (Edge e: n.getOutgoingEdges()){
                            Vertex adjNode = e.getDestination();
                            Integer newPossiblePathCost = 1+ n.getDistance();
                            if (newPossiblePathCost < adjNode.getDistance()){
                                    adjNode.setDistance(newPossiblePathCost);
                                    // update
                                    this.pQueue.remove(n);
                                    this.pQueue.add(n);
                            }
                    }
            }       
    }
    /**
    * 
    */
    public void PrintStatusOfPriorityQ(){
    	while (!pQueue.isEmpty()){
    		ArrayList<Vertex> temp = new ArrayList<Vertex>();
            Vertex n =pQueue.remove();
            temp.add(n);
            //System.out.println(n.getVal()+" distance=" + n.getDistance());
    }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
