package QueueGeneric;

public class SortGeneric {

   /*public static void sort(int[] input)
	{
		
	}*/
	//Although an interface is being implemented.
	//But we use "extends".Using this we make the T bound
	//to only those values which can be compared using Comparable interface. 
	public static<T extends Comparable<T>> void selectionSort(T[] input)
	{
		for(int i=0;i<input.length;i++)
		{
			int minIndex=i;
			T minValue=input[i];
			for(int j=i+1;j<input.length;j++)
			{
				if(input[j].compareTo(minValue)<0)
				{
					minIndex=j;
					minValue=input[j];
				}
				T temp=input[i];
				input[i]=input[minIndex];
				input[minIndex]=temp;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
