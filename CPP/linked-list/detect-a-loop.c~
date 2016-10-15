#include<stdio.h>
#include<stdlib.h>
//detect a loop
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

void detectALoop(struct node* head)
{
	struct node* slow=head;
	struct node* fast=head;
	if(fast==NULL)
	  return;
    while(fast->next!=NULL)
    {
    	fast=fast->next;
    	if(fast->next!=NULL && fast->data !=slow->data)
    	{
    		fast=fast->next;
    		slow=slow->next;
    	}
       else if(fast->next==NULL)
    	{
    		printf("No loop!\n");
    		return;
    	}
    	else if(fast->data==slow->data)
    	{
    		printf("There is a loop\n");
    		return;
    	}
    }
	 
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
   head->next->next->next->next = head;
   detectALoop(head);
   return 0;
}
