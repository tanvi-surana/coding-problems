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
    list<int> *adj;
public:
    Graph(int V);
    void addEdge(int w,int v);
    void TopSort();
    void TopSortUtil(int v,bool* visited,stack<int> &Stack);

};
Graph::Graph(int V)
{
    this->V=V;
    adj=new list<int>[V];
}
void Graph::addEdge(int v,int w)
{
    adj[v].push_back(w);
}

void Graph::TopSortUtil(int v,bool *visited,stack<int> &Stack)
{
    visited[v]=true;
    list<int> :: iterator i;
    for(i=adj[v].begin();i!=adj[v].end();i++)
    {
        if(visited[*i]==false)
            TopSortUtil(*i,visited,Stack);
    }

    Stack.push(v);
}
void Graph::TopSort()
{
    bool *visited=new bool[V];
    for(int i=0;i<V;i++)
    {
        visited[i]=false;
    }

    stack<int> Stack; 
    for(int i=0;i<V;i++)
        if(visited[i]==false)
            TopSortUtil(i,visited,Stack);

    //Print the contents of the stack
    
    while(!Stack.empty())
    {
        int x=Stack.top();
        cout<<x<<" ";
        Stack.pop();
    }   
}

int main()
{
    Graph g(6);
    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);
 
    cout << "Following is a Topological Sort of the given graph \n";
    g.TopSort();

    return 0;
}