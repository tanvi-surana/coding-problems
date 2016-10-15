#include<stdio.h>
#include<stdlib.h>
//print nth node from end
struct node
{
  struct node* next;
  int data;
};

void push(struct node** head_ref, int new_data)
{
    struct node* new_node =(struct node*) malloc(sizeof(struct node));
    new_node->data  = new_data;
    new_node->next = (*head_ref);    
    (*head_ref)    = new_node;
}

struct node* printNthNode(struct node* head,int n)
{
	struct node* slow=head;
	struct node* fast=head;
	int count=0;
	if(fast==NULL)
	  return NULL;
  
	while(count!=n-1)
	{
	  if(fast->next!=NULL)
		{
//			printf("%d ",fast->data);
			fast=fast->next;
		    count++;
		}
		else
		{
			return NULL;
		}
	}
	while(fast->next!=NULL)
	{
		fast=fast->next;
		slow=slow->next;
	}
	
	return slow;
}
 
void print(struct node* head)
{
  struct node* current=head;
  while(current!=NULL)
  { 
     printf("%d->",current->data); 
     current=current->next;
  }
  printf("NULL\n");
}

int main()
{
   struct node* head=NULL;
   struct node* current=NULL;
   push(&head,6);
   push(&head,5);
   push(&head,4);
   push(&head,3);
   push(&head,2);
   push(&head,1);
   print(head);
   current=printNthNode(head,3);
   printf("The nth node from the end is %d",current->data);
   return 0;
}
