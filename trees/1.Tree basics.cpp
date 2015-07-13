#include<cstdio>
#include<iostream>
#include<queue>
using namespace std;

struct node
{
	struct node* right;
	struct node* left;
	int data;
};

struct node* newNode(int data)
{
	struct node* current=new struct node;
	current->data=data;
	current->left=NULL;
	current->right=NULL;
	return current;
}

struct node* insert(struct node* root,int data)
{
	if(root==NULL)
		return newNode(data);

	if(root->left->data < data)
		return insert(root->right,data);
	else
		return insert(root->left,data);
} 

void printInorder(struct node* root)
{
	if(root==NULL)
		return;
	printInorder(root->left);
	cout<<root->data<<" ";
	printInorder(root->right); 

}

int numberOfNodes(struct node* root)
{
	if(root==NULL)
		return 0;
	return 1+numberOfNodes(root->right)+numberOfNodes(root->left);
}

int max(int a,int b)
{
	if(a>=b)
		return a;
	else
		return b;
}

int height(struct node* root)
{
	if(root==NULL)
		return 0;
	int leftHeight=height(root->left);
    int rightHeight=height(root->right);

   retun max(leftHeight,rightHeight); 
}

void levelOrderTraversal(struct node* root)
{
	queue<node*> q;
	q.push(root);
	while(!q.empty())
	{
		struct node* current=q.front();
		cout<<current->data<<" ";
		q.pop();
		if(current->left!=NULL)
			q.push(current->left);
		if(current->right!=NULL)
			q.push(current->right)

	}
}