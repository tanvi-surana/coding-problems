package graphMatrix;

import java.util.ArrayList;

public class graph {
       
	ArrayList<Vertex> vertices = new ArrayList<Vertex>();	
	boolean[][] adjacencyMatrix=new boolean[50][50];
      public graph(){
    	  
    	  for(int i=0;i<adjacencyMatrix.length;i++)
    		  vertices.add(i,null);
    	  
      }
      
      public boolean isEmpty(){
    	  for(int i=0;i<adjacencyMatrix.length;i++)
    	  {
    		  for(int j=0;j<vertices.size();i++)
    		  {
    			  if(adjacencyMatrix[i][j]==true)
    				  return false;
    		  }
    	  }
    	  return true;
      }
      
      public Vertex findVertex(String nameVertex){
    	   	  
    	  for(int i=0;i<adjacencyMatrix.length;i++)
    	  {
    		  if(vertices.get(i).name==nameVertex)
    		  {
    			  return vertices.get(i) ;
    		  }
    	  }
    	  return null;
      }
    	  
      
      public int numVertices(){
    	  int size=0;
    	  for(int i=0;i<adjacencyMatrix.length;i++)
    	  {
    		  if(vertices.get(i)!=null)
    		  {
    			  size++;
    		  }
    		  else
    		  {
    			  continue;
    		  }
 	  
    	  }
    	  
    	  return size;
      }
      
      public int numEdges(){
    	  int size=0 ; 
    	  for(int i=0;i<adjacencyMatrix.length;i++)
    	  {
    		  for(int j=0;j<vertices.size();i++)
    		  {
    			  if(adjacencyMatrix[i][j]==true)
    				  size++;
    		  }
    	  }
    	 return size/2; 
      }
      
      public void addVertex(String name){
    	  
    	  Vertex v =new Vertex();
    	  v.name=name;
    	  vertices.add(v);
    	  
    	   
      }
      
      public void addEdge(Vertex v1,Vertex v2){
    	  
    	//Edge e= new Edge();  
    	if(v1==null||v2==null)
    		return;
    	int i=0,j=0;
    	while(vertices.get(i)!=v1)
    	{
    		i++;
    	}
    	while(vertices.get(j)!=v2)
    	{
    		j++;
    	}
    	
    	adjacencyMatrix[i][j]=true;
      }
      
      public void addEdge(String s1,String s2)
      {
    	  int k=0,l=0;
    	  if(vertices==null)
    		  return;
     
    	 for(int i=0;i<adjacencyMatrix.length;i++)
    	 {	 
    		if(vertices.get(i)==null)
    			{
    			 l++;
    			 continue;
    			}
    		else if(vertices.get(i).name.equals(s1))	 
    	    { 
    			break;
    		} 
    		l++;
    	 
    	 }
    	 for(int j=0;j<adjacencyMatrix.length;j++)
    	 {	 
    		if(vertices.get(j)==null)
    			{
    			 k++;
    			 continue;
    			}
    		else if(vertices.get(k).name.equals(s2))	 
    	    { 			
    			break;
    		}
    		k++;
    	 
    	 }
    	  adjacencyMatrix[l][k]=true;
    	  
      }
      
      public void deleteVertex(Vertex v){
    	    
    	  for(int i=0;i<adjacencyMatrix.length;i++)
    	  {
    		  if(vertices.get(i)==v)
    		  {
    			   vertices.get(i).name=null;
    		  }
    	  }
      }
      
      public void deleteEdge(Vertex v1,Vertex v2){
    	  if(isEmpty())
    		  return;
    	  int i=0,j=0;
          while(vertices.get(i)!=v1)
       	 {
      		i++;
      	 }
      	 while(vertices.get(j)!=v2)
      	 {
      		j++;
      	 }
      	
      	adjacencyMatrix[i][j]=false;
    	  
      }
      
      public Vertex[] adjacentVertices(Vertex v){
    	   
    	  Vertex[] output=new Vertex[adjacencyMatrix.length];
    	  int i=0,k=0;
    	  while(vertices.get(i)!=v)
    		  i++;
    	  for(int j=0;j<adjacencyMatrix.length;i++)
    		   {
    		     if(adjacencyMatrix[i][j]==true)
    		     {
    		    	 output[k++]=vertices.get(j);
    		     }
    		   }
    		   
    		return output;  
      }
      
      public boolean isAdjacent(Vertex v1,Vertex v2){
    	  if(isEmpty())
    		  return false;
    	  int i=0,j=0;
    	  while(vertices.get(i)!=v1)
         {
       		i++;
       	 }
       	 while(vertices.get(j)!=v2)
       	 {
       		j++;
       	 }
       	 
       	 if(adjacencyMatrix[i][j]==true)
       		 return true;
       	 return false;
      }
      
 
      public static void main(String args[]){
    	  
    	  graph g = new graph();
    	  g.addVertex("D");
    	  g.addVertex("E");
    	  g.addVertex("L");
    	
    	  g.addEdge("D", "E");
    	  g.addEdge("E", "L");
    	  g.addEdge("D", "L");
    	  int num=g.numVertices();
    	  System.out.println(num);
    	
    	  
      }
      
      
}

