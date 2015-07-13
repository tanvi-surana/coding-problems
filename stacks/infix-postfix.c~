#include<stdio.h>
#include<stdlib.h>
//array implementation

struct Stack
{
  int top;
  unsigned int capacity;
  int* array;
};

struct Stack* createStack(unsigned capacity)
{
   //struct Stack* new_stack=(struct* Stack)malloc(sizeof(struct Stack));
   struct Stack* new_stack = (struct Stack*) malloc(sizeof(struct Stack));
   new_stack->top=-1;
   new_stack->capacity=capacity;
   new_stack->array=(int*) malloc(new_stack->capacity*sizeof(int)); 
   return new_stack;
}

int isFull(struct Stack* stack)
{
   return stack->top==stack->capacity-1;
}

int isEmpty(struct Stack* stack)
{
   return stack->top==-1;
}
void push(struct Stack* stack,int data)
{
  if(isFull(stack))
  {
    printf("The stack is full\n");
    return;
  }
   stack->array[++stack->top]=data;
   printf("%d pushed into the stack\n",data);
}

int pop(struct Stack* stack)
{
  if(isEmpty(stack))
  { 
    printf("The stack is empty\n");
    return 1;
  }  
  printf("The value popped out is %d\n",stack->array[stack->top]);
  
  return (stack->array[stack->top--]); 
  
}
int main()
{
   struct Stack* stack = createStack(2);
    pop(stack);
    push(stack, 10);
    push(stack, 20);
    push(stack, 30);
    pop(stack);
   return 0;
}
