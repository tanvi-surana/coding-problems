#include<stdio.h>
#include<stdlib.h>
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
//------------------------------------------------Find Middle
void findMiddleElement(struct node* head,struct node* a,struct node* b)
{
   struct node* slow=head;
   struct node* fast=head->next;

  if(head==NULL||head->next==NULL)
    { *a=head; *b= NULL;
     return;
    }
 else
  { while(fast!=NULL)
   { 
     fast=fast->next; 
     if(fast!=NULL)
      slow=slow->next;
      fast=fast->next;
   } 
  }  
   a=head;
   b=slow->next;
   
}
//------------------------------------------------Merge function
struct node* merge(struct node* a,struct node* b)
{
    struct node* result=NULL;
    if(a==NULL)
       return b;
    if(b==NULL)
       return a;
    if(a->data>=b->data)
      { 
          result=a
          return result->next=merge_sorted(a->next,b);
      }  
      else
      {  
         result=b;
         return result->next=merge_sorted(a,b->next);
      }
    return result;
}
//------------------------------------------------Merge sort
void mergeSort(struct node** head)
{
   struct node* middle=NULL;
   struct node* a,b;
   if((*head)==NULL||(*head)->next==NULL)
     return NULL;
   middle=findMiddleElement(head,a,b);
   mergesort(&a);
   mergesort(&b);
   *head=merge(a,b); 
   
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
   push(&head,1);
   push(&head,2);
   push(&head,3);
   push(&head,4);
   push(&head,5);
   push(&head,6);
   print(head);
   mergeSort(&head);
   print(head); 
   return 0;
}
