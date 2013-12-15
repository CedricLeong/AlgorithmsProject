
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


import java.util.*;

import Graph.*;

public class Dijkstra {	  
	
	private static PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
	
	// All the nodes in the graph
    public static ArrayList<Vertex> existingVertex = new ArrayList <Vertex> ();
    
    // Current diameter of the graph 
	public static int diameter;


    public static void execute(){
    	// Set the first node as source node 
    	existingVertex.get(0).setDistance(0);
    	
    	// Add all nodes into a heap
    	pQueue.addAll(existingVertex);
            while (!pQueue.isEmpty()){
            		
            		// Take out first node
                    Vertex n = pQueue.remove();
                    
                    
                    for (Edge e: n.getOutgoingEdges()){
                            Vertex adjNode = e.getDestination();
                            Integer newPossiblePathCost = 1+ n.getDistance();
                             adjNode.setDistance(newPossiblePathCost); // Might need to add a new if statement later on 
                                    // update
                             pQueue.remove(adjNode);
                             pQueue.add(adjNode);
                    }
                    
                    // Save the diameter of the traversed graph
                    if(n.getDistance() > diameter )
                    {
                    	diameter = n.getDistance();
                    }
            }       
            
    }


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Parse the sparse matrix in the given text file
		File file = new File("sparseMatrix.txt");
		  try {
			    FileReader reader = new FileReader(file);
			    BufferedReader buffReader = new BufferedReader(reader);
			    String curLine;
			    int row,col;
			    while((curLine = buffReader.readLine()) != null){
			   
			    StringTokenizer tk = new StringTokenizer(curLine, " ");
			    
			    while (tk.hasMoreTokens()) { 
			    		
			    		// Make each row number into a node
			    		row = Integer.parseInt(tk.nextToken());	
			    		Vertex newVertex = new Vertex(row);
			    		existingVertex.add(newVertex);
			    		for (int i = 0; i < existingVertex.size()-1; i++)
			    		{
			    			// If the node already exists then remove any duplicates
			    			if(existingVertex.get(i).id == row)
			    			{
			    				existingVertex.remove(existingVertex.size()-1);
			    			}
			    		}
			    		
			    		// The column number is made into a node that connects to the row node
			    		col = Integer.parseInt(tk.nextToken());
			    		Vertex connectedVertex = new Vertex(col);
			    		for (int i = 0; i < existingVertex.size(); i++)
			    		{

			    			if (existingVertex.get(i).id == row)
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
		  
		  // Print out the diameter
		  System.out.println("The diameter of the graph is:" + diameter);

	}

}
