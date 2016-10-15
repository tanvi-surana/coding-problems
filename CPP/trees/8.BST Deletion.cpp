#include<iostream>
#include<queue>
#define MAX 1000
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

node* findInorderPred(node* root)
{
    if(root==NULL || root->left==NULL)
    {
       return NULL;
    }

    node* pred=root->left;
    while(pred->right!=NULL)
      pred=pred->right;
    return pred;
}
 
node* deleteBST(node* root,int data)
{
  
  if(root==NULL)
  {
    return NULL;
  }
  if(root->data<data)  //less than
  {
     root->right= deleteBST(root->right,data);
     return root;
  }
  else if(root->data>data) //greater than
  {
      root->left= deleteBST(root->left,data);
      return root;
  }
  else   //equal to
  {
      if(root->left==NULL && root->right==NULL)
      {
        
         delete root;
         return NULL;
      } 
      else if(root->left==NULL )
      {
          node* temp=root->right;
          delete root;
          return temp;
      }
      else if(root->right==NULL)
      {
          node* temp=root->left;
          delete root;
          return temp;
      }
      else
      {
          node* temp=findInorderPred(root);
          root->data=temp->data;
          root->left=deleteBST(root->left,temp->data);
          return root;
      }
  }
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
 
 
int main(){
int a[8]={1,2,3,4,5,6,7,9};
struct node*root = NULL;
root = createBST(a,0,7);
cout<<"Originial "<<endl;
printLevelOrder(root);
insertBST(root,8);
cout<<endl<<"After inserting 8 "<<endl;

printLevelOrder(root);
 deleteBST(root,4);
 deleteBST(root,7);
cout<<endl;
printLevelOrder(root);
//printInorder(root);
//cout<<endl<<"Inorder : "<<endl;
//printPreorder(root);
return 0;
}
