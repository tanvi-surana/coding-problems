#include<iostream>
#include<cstdlib>
#define V 4
using namespace std;
/*
  All pair shortest path problem
*/

void floydWarshall(int graph[][V])
{
	int array[V][V];
	for(int i=0;i<V;i++)
	{
		for(int j=0;j<V;j++)
		{
			array[i][j]=graph[i][j];
		}
	}

	for(int k=0;k<V;k++)
	{
		for(int i=0;i<V;i++)
		{
			for(int j=0;j<V;j++)
			{
				if(array[i][k]+array[k][j]<array[i][j])
					array[i][j]=array[i][k]+array[k][j];
			}
		}
	}
            
    cout<<"The final matrix is"<<endl;
    for(int i=0;i<V;i++)
	{
		for(int j=0;j<V;j++)
		{
			cout<<array[i][j]<<" ";
		}
		cout<<endl;
	}       
}


int main()
{
	cout<<"Enter the graph matrix with four vertices"<<endl;
	int graph[V][V];
	for(int i=0;i<V;i++)
	{
		for(int j=0;j<V;j++)
		{
			cin>>graph[i][j];
		}
	}

	cout<<"The shortest dist between the various paths is"<<endl;

	floydWarshall(graph);
	return 0;
}