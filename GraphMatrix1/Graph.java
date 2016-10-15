package GraphMatrix1;

import GraphMatrix1.Vertex;

import java.util.ArrayList;

import trees.GenericsQueues;

public class Graph {

	ArrayList<Vertex> vertices= new ArrayList<Vertex>();
	boolean adj[][]=new boolean[50][50] ;
	 int num_of_vertices;
	//Constructor
	public Graph() {
		 num_of_vertices=0;
		//adj =new boolean[num_of_vertices][num_of_vertices];
		// TODO Auto-generated constructor stub
	}
	public boolean isEmpty(){
		return vertices.isEmpty();
	}
	public Vertex findVertex(String nameVertex){
		for(int i=0;i<num_of_vertices;i++)
		{
			 if(vertices.get(i).name==nameVertex)
			 {
				 return vertices.get(i);
			 }
		}
		return null;
	}
	public int numEdges(){
		
		int num_of_edges=0;
		for(int i=0;i<num_of_vertices;i++)
		{
			for(int j=0;j<num_of_vertices;j++)
			{
				if(adj[i][j]==true)
					num_of_edges++;
			}
		}
		return num_of_edges/2;
	}
	
	public int numOfVertices()
	{
		return num_of_vertices;
	}
  public Vertex addVertex(String name){
    	  
    	  Vertex v =new Vertex();
    	  v.name=name;
    	  vertices.add(v);	   
    	  num_of_vertices++;
    	return v; 
      }
  public void addEdge(Vertex v1,Vertex v2){
	  
	  int row=0,column=0;
	  for(int i=0;i<num_of_vertices;i++)
	  {
		  row=i;
		  if(vertices.get(i)==v1)
			  break;
	  }
	  
	  for(int j=0;j<num_of_vertices;j++)
	  {
		  column=j;
		  if(vertices.get(j)==v2)
			  break;
	  }
	  
	  adj[row][column]=true;
	  adj[column][row]=true;
  } 
  
  public void deleteVertex(Vertex v){
	  
	  for(int i=0;i<num_of_vertices;i++)
	  {
		  if(vertices.get(i)==v)
		  vertices.set(i,null);
	  }
	  num_of_vertices--;
  }
  public void deleteEdge(Vertex v1,Vertex v2){
	  int row=0,column=0;
	  for(int i=0;i<num_of_vertices;i++)
	  {
		  row=i;
		  if(vertices.get(i)==v1)
			  break;
	  }
	  
	  for(int j=0;j<num_of_vertices;j++)
	  {
		  column=j;
		  if(vertices.get(j)==v2)
			  break;
	  }
	  
	  adj[row][column]=false;
	  adj[column][row]=false;
  }
  
  public Vertex[] adjacentVertices(Vertex v){
	  
	  Vertex[] output=new Vertex[num_of_vertices];
	  int count=0;
	  int k=0;
	  for(int i=0;i<num_of_vertices;i++)
	  {
		 count++; 
		 if(vertices.get(i)==v)
			 break;
	  }
	  
	  for(int i=0;i<num_of_vertices;i++)
	  {
		  if(adj[count][i]==true)
			  output[k++]=vertices.get(i);
	  }
	  
	  return output;
  }
  public boolean isAdjacent(Vertex v1,Vertex v2){
	  int countV1=0,countV2=0;
	  for(int i=0;i<num_of_vertices;i++)
	  {
		  countV1++;
		  if(vertices.get(i)==v1)
			  break;
	  }
	  for(int i=0;i<num_of_vertices;i++)
	  {
		  countV2++;
		  if(vertices.get(i)==v2)
			  break;
	  }
	  
	  if(adj[countV1][countV2]==true)
		  return true;
	  return false;
	  
  }
  
  public void BFS(Graph g,Vertex start,String search)
  {
	  GenericsQueues<Vertex> vertex_queue=new GenericsQueues<Vertex>();
	  ArrayList<Vertex> visited= new ArrayList<Vertex>();
	  vertex_queue.enqueue(start);
	  
	  while(!vertex_queue.isEmpty())
	  {
		  Vertex front=vertex_queue.dequeue();
		  if(front.name==search)
		  {
			  System.out.println("found");
			  return;
		  }
		  visited.add(front);
		  
		  Vertex[] adjacent = g.adjacentVertices(front);
		  int i=0;
		  while(adjacent[i]!=null){
				if (!visited.contains(adjacent[i])) 
				{
					vertex_queue.enqueue(adjacent[i]);
				}
		     i++;
		  }
     }
	  System.out.println("not found");
  }
	  
	  
  
 
  public String getVertex(int i)
  {
	  return vertices.get(i).name;
  }
  
  public void printAdjancyMatrix()
  {
	  for(int i=0;i<num_of_vertices;i++)
		  System.out.print(getVertex(i));
	  System.out.println();
	  for(int i=0;i<numOfVertices();i++)
	     {
	    	 for(int j=0;j<numOfVertices();j++)
	    	 {
	    		 System.out.print(adj[i][j]+" ");
	    	 }
	    	System.out.println(); 
	     }
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Graph g=new Graph();
     Vertex v1=g.addVertex("D");
     Vertex v2=g.addVertex("E");
     Vertex v3=g.addVertex("L");
     
     g.addEdge(v1, v2);
     g.addEdge(v1, v3);
     
     g.printAdjancyMatrix();
     System.out.println();
     //g.deleteEdge(v1, v2);
     
     g.printAdjancyMatrix();
     System.out.println();
     g.deleteVertex(v3);
     
     g.printAdjancyMatrix();
     
     System.out.println("BFS");
     g.BFS(g,v1,"E");
	}

}
