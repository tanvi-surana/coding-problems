  package fundamentals;

import java.util.Scanner;

public class Permutations {

	public static void takeInput(int input[])
	{
		Scanner console= new Scanner(System.in);
		for(int i=0;i<input.length;i++)
		{
			input[i]=console.nextInt();
		}
	}
	public static int fact(int n)
	{
		if(n==0)
		{
			return 1;
		}
		
		return n*fact(n-1);
		
	}
	public static int Logic(int input[])
  {
	  int count=0;
	  for(int i=0;i<input.length;i++)
	  {
		  int temp=input[0];
		  if(input[i]>temp)
		   {
			  count+=fact(input.length-1);
		   }
	  }
	  return count;
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println("Enter the number of digits");
      Scanner console= new Scanner(System.in);
      int n=console.nextInt();
      System.out.println("Enter the array");
      int input[]=new int[n];
      takeInput(input);
      int x=Logic(input);
      System.out.println("Numbers greater than the input are "+x);
	}

}
