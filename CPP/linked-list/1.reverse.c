#include<stdio.h>
#include<stdlib.h>
/*
  Author-Tanvi Surana
  Reverse a linked list iteratively and recursively.
*/
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
 
void reverseIterative(struct node** headRef)
{
   struct node* current=*headRef;
   struct node* prev=NULL;
   struct node *next;
   
   while(current!=NULL)
   {
     next=current->next;    
     current->next=prev;
     prev=current;
     current=next;
   }    

   *headRef=prev;
}

void recursiveReverse(struct node** head)
{
   struct node* first=*head;
   struct node* rest=first->next; 
   if(first==NULL)
     return;
   if(rest==NULL)
     return;
   recursiveReverse(&rest);
   first->next->next=first;
   first->next=NULL;
   *head=rest;
      
}
void print(struct node* head)
{
  struct node* current=head;
  while(current!=NULL)
  { 
     printf("%d->",current->data); 
     current=current->next;
  }
  printf("\n");
}

int main()
{
   struct node* head=NULL;
   push(&head,3);
   push(&head,2);
   push(&head,1);
   print(head);
   reverseIterative(&head);
   print(head);
   recursiveReverse(&head);
   print(head);
   return 0;
}
