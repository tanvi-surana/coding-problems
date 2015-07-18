 #include<iostream>
#include<queue>
using namespace std;

struct node
{
	node* left;
	node* right;
	int data;
};

node* insert()
{
	node* root= new node;
    queue<node*> q; 
    cout<<"Enter the root's data";
    cin>>root->data;
    q.push(root);

    while(!q.empty())
    {
    	node* temp= q.front();
    	q.pop();
    	int data1,data2;
    	cout<<"Enter data for left and right child of "<<temp->data<<"else enter -1"<<endl;
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
			q.push(current->right);

	}
}

node* printMirror(node* root)
{
    if(root==NULL)
    {
    	return NULL;
    } 
    else
    {
    	node* temp=printMirror(root->left);
    	root->left=printMirror(root->right);
    	root->right=temp;
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
	if(root==NULL)
	  return 0;
	int lHeight=height(root->left);
	int rHeight=height(root->right);

	return 1+max(lHeight,rHeight);
}
int diameter(node* root)
{
	//incude the root
	if(root==NULL)
	  return 0;
    int diameter1=1+height(root->left)+height(root->right);
    int diameter2=diameter(root->left);
    int diameter3=diameter(root->right);

    return max(diameter1,max(diameter2,diameter3));

}
int main()
{
    node* root=insert();
    levelOrderTraversal(root);
    cout<<height(root);
    
   cout<<diameter(root);
   // printMirror(root);
    //levelOrderTraversal(root);
}