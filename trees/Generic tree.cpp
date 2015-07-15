#include<iostream>
#include<queue>
using namespace std;

struct node
{
	node** children;
	int data;
	int childCount;
};


node* insert()
{
	queue<node*> q;
	int data;
	node* root=new node;
	cout<<"Enter the root"<<endl;
    cin>>root->data;
    q.push(root);
    while(!q.empty())
    {
    	node* current=q.front();
    	q.pop();
    	cout<<"Enter the number of children of "<<current->data<<endl;
    	cin>>current->childCount;
        current->children=new node*[current->childCount];

        for(int i=0;i<current->childCount;i++)
        {
        	current->children[i]=new node;
        	cout<<"Enter the data for "<<i<<endl;
        	cin>>current->children[i]->data;
        	q.push(current->children[i]);
        } 


    }

    return root; 
}


void build_recursively(node** root)
{
	if(root==NULL)
    {
    	cout<<"Enter the data"<<endl;
    	cin>>(*root)->data;
    	cout<<"Enter the number of children for root with data"<<(*root)->data<<endl;
    	cin>>(*root)->childCount;
    	if((*root)->childCount==0)
    		return;
    	(*root)->children=new node[(*root)->childCount];
    	for(int i=0;i<(*root)->childCount;i++)
    	{
            (*root)->children[i]=NULL;
            build_recursively((*root)->children[i]);
    	}

    }

}

void printLevelOrder(node* root)
{
	queue<node*> q;
	q.push(root);
	while(!q.empty())
	{
		node* current=q.front();
		cout<<current->data;
		q.pop();
		
	}
}