package Graphs;

public class Vertex {
	String name;
	Node<Edge> adjacencyList;
	
	public boolean isAdjacent(Vertex v) {
		Node<Edge> tempEdge = adjacencyList;
		while (tempEdge != null) {
			Edge currentEdge = tempEdge.data;
			if (currentEdge.one == v || currentEdge.two == v)
			{
				return true;
			}
			tempEdge = tempEdge.next;
		}
		return false;
	}
	
	public int numEdges(){
		int size=0;
		Node<Edge> tempEdge = adjacencyList;
		while (tempEdge != null) {
		tempEdge = tempEdge.next;
			size++;
			
		}
		return size;
	}
	
	public void removeEdgeWithVertex(Vertex v) {
		Node<Edge> tempEdge = adjacencyList;
		Node<Edge> prev = null;
		while (tempEdge != null) {
			if(tempEdge.data.one == v  || tempEdge.data.two == v)
			{
				if (prev != null) {
					prev.next = tempEdge.next;
				} else 
				{//found at the head
					adjacencyList =  tempEdge.next;
				}
			}
			prev = tempEdge;
			tempEdge = tempEdge.next;
		}
	}
	
	public void addEdge(Edge e) {
		//add at the front
		Node<Edge> newEdgeNode = new Node<Edge>();
		newEdgeNode.data = e;
		newEdgeNode.next = adjacencyList;
		adjacencyList = newEdgeNode;
	}
	
	public Vertex[] adjacentVertices() {
		Vertex[] output = new Vertex[numEdges()];
		Node<Edge> tempEdge = adjacencyList;
		int i=0;
		while (tempEdge != null) {
			if(tempEdge.data.one == this )
			{
				output[i] = tempEdge.data.two;
				i++;
			}
			if(tempEdge.data.two == this )
			{
				output[i] = tempEdge.data.one;
				i++;
			}
			tempEdge = tempEdge.next;
		}
		return output;
	}
	
}
