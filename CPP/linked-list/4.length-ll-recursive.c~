#include<stdio.h>
#include<stdlib.h>
//length of a ll (recursive)
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

int length(struct node* head)
{
	if(head==NULL)
	  return 0;
	return 1+length(head->next) ; 
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
   printf("The length of the linked list is %d",length(head));
   //print(head);
   return 0;
}
