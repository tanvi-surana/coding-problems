package Graphs;

import java.util.ArrayList;

public class Graph {
	ArrayList<Vertex> vertices;
	
	
	public Graph() {
		//initialise..create an object using new
		vertices = new ArrayList<Vertex>();
	}
	
	public boolean isEmpty() {
		return vertices.isEmpty();
	}
	
	public Vertex findVertex(String name) {
		for (int i =0; i < vertices.size(); i++) {
			if (vertices.get(i).name == name)
				return vertices.get(i);
		}
		return null;
	}
	
	public int numVertices() {
		return vertices.size();
	}
	
	public int numEdges() {
		int totalEdges = 0;
		for (int i = 0; i < vertices.size(); i++) {
			totalEdges += vertices.get(i).numEdges();
		}
		return totalEdges/2;
	}
	
	public void addVertex(String name) {
		Vertex v = new Vertex();
		v.name = name;
		vertices.add(v);
	}
	
	public void addEdge(Vertex v1, Vertex v2) {
		// throw an Exception if v1 or v2 not in graph
		
		Edge e = new Edge();
		e.one = v1;
		e.two = v2;
		v1.addEdge(e);
		v2.addEdge(e);
	}
	
	public void deleteVertex(Vertex v) {
		vertices.remove(v);
		Vertex[] adjacent = adjacentVertices(v);
		for (int i = 0; i < adjacent.length; i++) {
			adjacent[i].removeEdgeWithVertex(v);
		}
	}
	
	public void deleteEdge(Edge e) {
		e.one.removeEdgeWithVertex(e.two);
		e.two.removeEdgeWithVertex(e.one);
	}
	
	public Vertex[] adjacentVertices(Vertex v) {
		return v.adjacentVertices();
	}
	
	public boolean isAdjacent(Vertex v1, Vertex v2) {
		return v1.isAdjacent(v2);
	}
	
//	public boolean isConnected(Vertex v1, Vertex v2) {
//		
//	}
}
