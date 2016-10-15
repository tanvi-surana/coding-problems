package Graphs;

import java.util.ArrayList;

import trees.GenericsQueues;
import queue.QueueLL;

public class GraphUse {
	
	public static void BFS(Graph g, Vertex start, String toBeFound) {
		GenericsQueues<Vertex> vertexQueue = new GenericsQueues<Vertex>();
		vertexQueue.enqueue(start);
		ArrayList<Vertex> visited = new ArrayList<Vertex>();
		
		while (!vertexQueue.isEmpty()) {
			Vertex front = vertexQueue.dequeue();
			if (front.name == toBeFound) {
				System.out.println("found");
				return;
			}
			visited.add(front);
			System.out.println("Adding new");
			Vertex[] adjacent = front.adjacentVertices();
			for (int i =0; i < adjacent.length; i++) {
				if (!visited.contains(adjacent[i])) {
					vertexQueue.enqueue(adjacent[i]);
				}
			}
		}
		
		System.out.println("not found");
		
	}
	
	public static void main(String args[]) {
		Graph g = new Graph();
		g.addVertex("D");
		g.addVertex("G");
		g.addVertex("F");
		g.addVertex("N");
		
		Vertex D = g.findVertex("D");
		Vertex G = g.findVertex("G");
		Vertex F = g.findVertex("F");
		Vertex N = g.findVertex("N");
		
		g.addEdge(D, G);
		g.addEdge(N, F);
		//g.addEdge(D, N);
		//g.addEdge(G, F);
		//g.addEdge(F, N);
		
		BFS(g, G, "N");
		
		
	}
}
