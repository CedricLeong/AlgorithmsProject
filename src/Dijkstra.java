
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


import java.util.*;

import Graph.*;

public class Dijkstra {	  
	
	private static PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
    public static ArrayList<Vertex> existingVertex = new ArrayList <Vertex> ();

    public static void execute(){
    	pQueue.addAll(existingVertex);
            while (!pQueue.isEmpty()){
                    Vertex n = pQueue.remove();
                    for (Edge e: n.getOutgoingEdges()){
                            Vertex adjNode = e.getDestination();
                            Integer newPossiblePathCost = 1+ n.getDistance();
                            if (newPossiblePathCost < adjNode.getDistance()){
                                    adjNode.setDistance(newPossiblePathCost);
                                    // update
                                    pQueue.remove(n);
                                    pQueue.add(n);
                            }
                    }
            }       
    }
    /**
    * 
    */
    public static void PrintStatusOfPriorityQ(){
    	while (!pQueue.isEmpty()){
    		ArrayList<Vertex> temp = new ArrayList<Vertex>();
            Vertex n =pQueue.remove();
            temp.add(n);
            System.out.println(n.getId()+" distance=" + n.getDistance());
    }
    		
    }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("sparseMatrix.txt");
		  try {
			    FileReader reader = new FileReader(file);
			    BufferedReader buffReader = new BufferedReader(reader);
			    String curLine;
			    int row,col;
			    while((curLine = buffReader.readLine()) != null){
			   
			    StringTokenizer tk = new StringTokenizer(curLine, " ");
			    
			    while (tk.hasMoreTokens()) { 

			    		row = Integer.parseInt(tk.nextToken());	
			    		Vertex newVertex = new Vertex(row);
			    		existingVertex.add(newVertex);
			    		for (int i = 0; i < existingVertex.size()-1; i++)
			    		{
			    			if(existingVertex.get(i).id == row)
			    			{
			    				existingVertex.remove(existingVertex.size()-1);
			    			}
			    		}
			    		col = Integer.parseInt(tk.nextToken());
			    		Vertex connectedVertex = new Vertex(col);
			    		for (int i = 0; i < existingVertex.size()-1; i++)
			    		{
			    			if(existingVertex.get(i).id == row)
			    			{
					    		existingVertex.get(i).addOutgoingEdge(connectedVertex);
					    		existingVertex.add(connectedVertex);
			    			}
			    		}

			    		
			    		}
			    
			    }
			    
			    buffReader.close();
			    
			 }
			  catch(IOException e){
				  
				  System.out.println( System.getProperty( "user.dir" ) );
			    System.exit(0);
			    
			}
		  	
		  	// Call Dijkstra 
		  execute();			
		  PrintVertexs();
  		  PrintStatusOfPriorityQ();		  

	}
	private static void PrintVertexs() {
		// TODO Auto-generated method stub
    	for (Vertex v: pQueue){
            System.out.println(v.getId());
    	}
		
	}

}
