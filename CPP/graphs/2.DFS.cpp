#include<iostream>
#include<stack>
#include<vector>
#include<list>
using namespace std;

/*DFS
  
*/
class Graph
{
	int V;
	list<int*> adj;
public:
	Graph(int V);
	void insert(int w,int v);
	void DFS(int s);

};
Graph::Graph(int V)
{
	this->V=V;
	adj=new list<int>[V];
}
void Graph::insert(int v,int w)
{
	adj[v].push_back(w);
}
void Graph::DFS(int s)
{
	bool *visited=new bool[V];
	for(int i=0;i<V;i++)
		visited[i]=false;
	DFSUtil(visited,s);

}
void DFSUtil(int *visited,int s)
{
	visited[s]=true;
	cout<<s<<" ";
	list<int>::iterator i;

	for(i=adj[s].begin();i!adj[s].end();i++)
		if(!visited[*i])
			DFSUtil(visited,*i);
}

int main()
{
	return 0;
}