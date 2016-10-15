#include<iostream>
#include<queue>
#include<list>
#include<cstdlib>
#include<climits>
using namespace std;
/*
   This works on negative edges unlike dijkstra.
   It is simpler in comparison to diji and well suiteed for distributed systems
   Also helps detect negative weight cycle

   Steps involved:
1) This step initializes distances from source to all vertices as infinite and distance to source itself as 0.  
 Create an array dist[] of size |V| with all values as infinite except dist[src] where src is source vertex.

2) This step calculates shortest distances. 
Do following |V|-1 times where |V| is the number of vertices in given graph.
…..a) Do following for each edge u-v
………………If dist[v] > dist[u] + weight of edge uv, then update dist[v]
………………….dist[v] = dist[u] + weight of edge uv

3) This step reports if there is a negative weight cycle in graph. Do following for each edge u-v
……If dist[v] > dist[u] + weight of edge uv, then “Graph contains negative weight cycle”
The idea of step 3 is, step 2 guarantees shortest distances if graph doesn’t contain negative weight cycle. If we iterate through all edges one more time and get a shorter path for any vertex, then there is a negative weight cycle
*/

struct Edge
{
	int s,d,weight;
};

struct  Graph
{
    int V,E;
    Edge *edge;	
};

struct Graph* createGraph(int V,int E)
{
	struct Graph *g =(struct Graph*) malloc(sizeof(struct Graph));
	g->V=V;
	g->E=E;
	g->edge=(struct Edge*)malloc(sizeof(struct Edge)*g->E);
  return g;
}

void BellmanFord(struct Graph *g,int source)
{
	int v=g->V;
	int e=g->E;
	int dist[v];

	//initialise the distance of all to infinity

	for(int i=0;i<v;i++)
	{
		dist[i]=INT_MAX;
	}

   //distance of source from itself is 0
	dist[source]=0;

	for(int i=1;i<=v-1;i++)
	{
		for(int j=0;j<e;j++)
		{
			int u=g->edge[j].s;
			int v=g->edge[j].d;
			int weight=g->edge[j].weight;
             if(dist[u]!=INT_MAX && dist[u]+weight<dist[v])
             	dist[v]=dist[u]+weight;
		}
	}


	//check for the negative weight cycle

	for(int j=0;j<e;j++)
	{
		int u=g->edge[j].s;
			int v=g->edge[j].d;
			int weight=g->edge[j].weight;
             if(dist[u]!=INT_MAX && dist[u]+weight<dist[v])
             	cout<<"This countains negative weight cycle"<<endl;
	}

	//else print the dist array
	
	for(int i=0;i<v;i++)
	{
		cout<<i<<"  "<<dist[i]<<endl;
	}

}

int main()
{
	 /* Let us create the graph given in above example */
    int V = 5;  // Number of vertices in graph
    int E = 8;  // Number of edges in graph
    struct Graph* graph = createGraph(V, E);
 
    // add edge 0-1 (or A-B in above figure)
    graph->edge[0].s = 0;
    graph->edge[0].d = 1;
    graph->edge[0].weight = -1;
 
    // add edge 0-2 (or A-C in above figure)
    graph->edge[1].s = 0;
    graph->edge[1].d = 2;
    graph->edge[1].weight = 4;
 
    // add edge 1-2 (or B-C in above figure)
    graph->edge[2].s = 1;
    graph->edge[2].d = 2;
    graph->edge[2].weight = 3;
 
    // add edge 1-3 (or B-D in above figure)
    graph->edge[3].s = 1;
    graph->edge[3].d = 3;
    graph->edge[3].weight = 2;
 
    // add edge 1-4 (or A-E in above figure)
    graph->edge[4].s = 1;
    graph->edge[4].d = 4;
    graph->edge[4].weight = 2;
 
    // add edge 3-2 (or D-C in above figure)
    graph->edge[5].s = 3;
    graph->edge[5].d = 2;
    graph->edge[5].weight = 5;
 
    // add edge 3-1 (or D-B in above figure)
    graph->edge[6].s = 3;
    graph->edge[6].d = 1;
    graph->edge[6].weight = 1;
 
    // add edge 4-3 (or E-D in above figure)
    graph->edge[7].s = 4;
    graph->edge[7].d= 3;
    graph->edge[7].weight = -3;
 
    BellmanFord(graph, 0);
 
	return 0;
}