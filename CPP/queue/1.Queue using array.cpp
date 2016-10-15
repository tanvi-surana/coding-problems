#include<iostream>
#define MAX 100
using namespace std;

struct Queue
{
	int rear;
	int front;
	int currentSize;
	int array[MAX];
};

void enQueue(Queue &Q,int data) //C++ reference parameter
{
    if(Q.currentSize==MAX)
    {
    	cout<<"Queue is full"<<endl;
    	return;
    }
    Q.array[++Q.rear]=data;
    Q.currentSize++;

}
int deQueue(Queue &Q)
{
   if(Q.currentSize==0)
   {
       cout<<"Queue is empty"<<endl;
        return 0;
   }
   
   Q.currentSize--;  
   return Q.array[Q.front++];

}
int front(Queue &Q)
{
    return Q.array[Q.front];
}
int main()
{
	Queue Q;
	Q.rear=-1;
	Q.front=0;
	Q.currentSize=0;
	enQueue(Q,1);
	enQueue(Q,2);
	enQueue(Q,3);
	cout<<deQueue(Q);
}
