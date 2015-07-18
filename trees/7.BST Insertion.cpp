 #include<iostream>
#include<queue>
using namespace std;
struct node
{
	node* left;
	node* right;
	int data;
};

node* insertBST(node* root,int data)
{
	if(root==NULL)
	{
		node* newNode=new node;
		newNode->data=data;
		newNode->left=NULL;
		newNode->right=NULL;
		return newNode;
	}
	if(root->data<data)
		root->right= insertBST(root->right,data);
    else if(root->data>data)
    	root->left= insertBST(root->left,data);

  return root; 

}

 
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
	queue<node*> q;
	q.push(root);
	q.push(NULL);
    while(!q.empty())
    {
    	node* temp=q.front();
    	q.pop();
        if(q.empty())
        {
        	cout<<endl;
        	break;
        }
        if(temp==NULL)
        {
            q.push(NULL);
            cout<<endl; 
        }
        else
         {
         	 cout<<temp->data<<" ";
            if(temp->left!=NULL)
             q.push(temp->left);
            if(temp->right!=NULL)
             q.push(temp->right);   
          }     
 
    }
}
 }
int main(){
int a[8]={1,2,3,4,5,6,7,9};
struct node*root = NULL;
root = createBST(a,0,7);
cout<<"Originial "<<endl;
printLevelOrder(root);
insertBST(root,8);
cout<<endl<<"After inserting 8 "<<endl;

printLevelOrder(root);
cout<<endl<<"Inorder : "<<endl;
//printPreorder(root);
return 0;
}
