#include<stdio.h>
#include<stdlib.h>
//remove duplicates from a sorted linkedlist.Traverse only once
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

void removDuplicates(struct node** head)
{
	struct node* current=*head;
	//struct node* next=current;
	if(current==NULL)
	  return;
	while(current->next!=NULL)
	{
		if(current->data==current->next->data)
		{
			struct node* temp=current->next;
			current->next=current->next->next;
			free(temp);
		}
		else
		{
			current=current->next;
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
   push(&head,3);
   push(&head,3);
   push(&head,2);
   push(&head,1);
   push(&head,1);
   push(&head,1);
   print(head);
   removDuplicates(&head);
   print(head);
   return 0;
}
