import java.util.Scanner;


public class qset1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String input="01234";
       String empty="";
       Scanner console=new Scanner(System.in);
       int x=console.nextInt();
       int y=console.nextInt();
       for(int i=x;i<y;i++)
       {
    	   for(int j=i;j<y;j++)
    	   {
    		   String result=input.substring(i, j);
    		   if(result.equals(empty))
    			 System.out.println("Empty String");
    		   System.out.println(result);
    		   //System.out.println(input.substring(i, j));
    	   }
       }
	}

}
