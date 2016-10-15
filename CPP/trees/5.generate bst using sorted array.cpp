#include<iostream>
#include<queue>
using namespace std;

struct node
{
	node* left;
	node* right;
	int data;
};

 node* createBST(int *a,int low,int high)
 {
 	if(low==high)
 	{
        node* leaf=new node;
        leaf->data=a[low];
        leaf->left=NULL;
        leaf->right=NULL;
        return leaf;
 	}
   else if(low<high)
 	{
 		int mid=(low+high)/2;
 		node* root=new node;
 		root->data=a[mid];
 		root->left=createBST(a,low,mid-1);
 		root->right=createBST(a,mid+1,high);
 		return root;
 	}
 	return NULL;
 }

void printLevelOrder(node* root)
{
	//cout<<root->data;
	queue<node*> q;
	q.push(root);
	while(!q.empty())
	{
		node* temp=q.front();
		cout<<temp->data;
		q.pop();
		if(temp->left!=NULL)
		{
			q.push(temp->left);
		}
	 if(temp->right!=NULL)
		{
			q.push(temp->right);
		} 


	}
}

int main()
{
   int a[]={1,2,3,4,5,6,7,8};
   node* root=createBST(a,0,7);
   printLevelOrder(root);
}