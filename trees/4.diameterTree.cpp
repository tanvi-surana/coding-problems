#include<iostream>
#include<cstdio>
#include<queue>
using namespace std;

struct node*
{
	node* left;
	node* right;
	int data
};
node* insert(node* root)
{
   node* root=new node;
   cout<<"Enter the root's data"<<endl;
   cin>>root->data;
   queue<node*> q;
   q.push(root)
   while(!q.empty())
   {
   	 node* temp=q.front();
   	 int data1,data2;
   	 cout<<"Enter the data for left and right child else enter -1 for "<<temp->data;
   	 cin>>data1>>data2;
   	 if(data1!=-1)
   	 {
         temp->left=new node;
         temp->left->data=data1;  
         q.push(temp->left);
   	 }
   	 else
   	 {   
   	 	temp->left=NULL;
   	 }

   	 if(data2!=-1)
   	 {
         temp->right=new node;
         temp->right->data=data2;  
         q.push(temp->right);
   	 }
   	 else
   	 {   
   	 	temp->right=NULL;
   	 }
   } 
   return root;
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
		{if(data1!=-1)
   	 {
         temp->left=new node;
         temp->left->data=data1;  
         q.push(temp->left);
   	 }
   	 else
   	 {   
   	 	temp->left=NULL;
   	 }
			q.push(temp->right);
		}  


	}
}
int max(int a,int b)
{
	if(a>=b)
		return a;
	return b;
}
int height(node* root)
{
	int lHeight=height(root->left);
	int rHeight=height(root->right);

	return 1+max(lHeight,rHeight);
}
int diameter(node* root)
{
	//incude the root
    int diameter1=1+height(root->left)+height(root->right);
    int diameter2=diameter(root->left);
    int diameter3=diameter(root->right);

    return max(diameter1,max(diameter2,diameter3));

}

int main()
{
	node* root= insert();
	printLevelOrder(root);
	cout<<"The diameter of the binary tree is "<<diameter(root);
	return 0;
}