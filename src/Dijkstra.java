
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
	public static int diameter;


    public static void execute(){
    	existingVertex.get(0).setDistance(0);
    	pQueue.addAll(existingVertex);
            while (!pQueue.isEmpty()){

                    Vertex n = pQueue.remove();
                    if(n.getDistance() > diameter )
                    {
                    	diameter = n.getDistance();
                    }
                    for (Edge e: n.getOutgoingEdges()){
                            Vertex adjNode = e.getDestination();
                            Integer newPossiblePathCost = 1+ n.getDistance();
                             adjNode.setDistance(newPossiblePathCost);
                                    // update
                             pQueue.remove(adjNode);
                             pQueue.add(adjNode);
                    }
            }       
            
    }
    /**
    * 
    */
    public static void PrintStatusOfPriorityQ(){
    	while (!pQueue.isEmpty()){
            Vertex n =pQueue.remove();
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
			    int row,col, tkcount =0;
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
		  System.out.println("The diameter of the graph is:" + diameter);

	}
	private static void PrintVertexs() {
		// TODO Auto-generated method stub
    	for (Vertex v: pQueue){
            System.out.println(v.getId()+ " distance=" + v.getDistance());
    	}
		
	}

}
