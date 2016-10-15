import java.util.Scanner;


public class qset {
	public static String case1(String input,int x,int y)
	{
	   
		input=input.substring(0, x)+y+input.substring(x+1,input.length());
		return input;
	}
 
	public static void case2(String input,int c,int d)
	{
		int count=0;
		c=c-1;
		d=d-1;
		for(int i=c;i<d;i++)
		{
			for(int j=i;j<d+2;j++)
			{   
				int num;
				String result=input.substring(i, j);
				if(result.equals(""))
				{ 
					result="4";	
				}
				System.out.println(result);
 				num = Integer.parseInt(result);
 				if(num%3==0)
					count++;
				
			}
		}
//		System.out.println(count);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner console=new Scanner(System.in);
      int n=console.nextInt();
      int m=console.nextInt();
      String input=console.next();
      for(int i=0;i<m;i++)
      {
    	  int a=console.nextInt();
    	  int x=console.nextInt();
    	  int y=console.nextInt();
   	  if(a==1)
    	  {
    		  input=case1(input,x,y);
    	  }
    	  else
    	  {
    		  case2(input,x,y);
    	  } 	  
     }
		
	}
//      case2("01235",1,6);
}
