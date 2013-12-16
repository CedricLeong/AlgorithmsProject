
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


import java.util.*;

import Graph.*;

public class Dijkstra {	  
		
	// All the nodes in the graph
    public static ArrayList<Vertex> existingVertex = new ArrayList <Vertex> ();
    
    // Current diameter of the graph 
	public static  ArrayList<Integer> diameterlist = new ArrayList <Integer> ();


    public static void execute(int source){
      PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();

    	// Set the first node as source node 
    	int diameter =0;
    	existingVertex.get(source).setDistance(0);
    	
    	// Add all nodes into a heap
    	pQueue.addAll(existingVertex);
            while (!pQueue.isEmpty()){
            		
            		// Take out first node
                    Vertex n = pQueue.remove();
                    n.setVisited(true);
          		  System.out.println("original id:" + n.id);

                    
                    for (Edge e: n.getOutgoingEdges()){
                            Vertex adjNode = e.getDestination();
                    		  System.out.println("id:" + adjNode.id);
                    		  System.out.println("visited:" + adjNode.visited);


                            Integer newPossiblePathCost = 1+ n.getDistance();
                            if (Boolean.FALSE.equals(adjNode.isVisited())) {

                            if (newPossiblePathCost<adjNode.getDistance()){
                             adjNode.setDistance(newPossiblePathCost); 
                     		 System.out.println("distance:" + adjNode.getDistance());

                                    // update
                             pQueue.remove(adjNode);
                             pQueue.add(adjNode);}}
                    }
                    
                    // Save the diameter of the traversed graph
                    if(n.getDistance() > diameter  && n.getDistance() != 999999)
                    {
                    	diameter = n.getDistance();
                    }
            }       
            
            diameterlist.add(diameter);
            
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
			    		existingVertex.add(connectedVertex);
			    		
			    		boolean found = false;
			    		for (int i = 0; i < existingVertex.size(); i++)
			    		{

			    			if (existingVertex.get(i).id == row)
			    			{
					    		for (int j = 0; j < existingVertex.size()-1; j++)
					    		{
					    			// If the node already exists then remove any duplicates
					    			if(existingVertex.get(j).id == col)
					    			{
					    				existingVertex.remove(existingVertex.size()-1);
					    				existingVertex.get(i).addOutgoingEdge(existingVertex.get(j));
					    				existingVertex.get(j).addOutgoingEdge(existingVertex.get(i));
					    				found = true;
					    			}
					    		}
					    		
			    			}
			    			
			    		}
			    		if (!found)
			    		{
				    		for (int i = 0; i < existingVertex.size(); i++)
				    		{

				    			if (existingVertex.get(i).id == row)
				    			{
		    				existingVertex.get(i).addOutgoingEdge(existingVertex.get(existingVertex.size()-1));
		    				existingVertex.get(existingVertex.size()-1).addOutgoingEdge(existingVertex.get(i));}}
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
  		for (int i = 0; i < existingVertex.size()-1; i++)
  		{

  			execute(i);	
  			System.out.println("Small bug");
    		for (int j = 0;j < existingVertex.size()-1; j++)
    		{
    			// reset node values
    			existingVertex.get(j).visited = false;
    			existingVertex.get(j).distance = 999999;

    		}
  			
  		}		
		  
  		int graphdiameter = 0;
		  // Print out the diameter
  		for (int i = 0; i < diameterlist.size()-1; i++)
  		{
  			if (diameterlist.get(i) > graphdiameter)
  				graphdiameter = diameterlist.get(i);
  		}
		  System.out.println("The diameter of the graph is:" + graphdiameter);

	}

}
