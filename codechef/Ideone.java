package codechef;


import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{  
	
	public static int gcd(int a, int b){
	    a = Math.abs(a); b = Math.abs(b);
	    return (b==0) ? a : gcd(b, a%b);
	  }
	public static void main (String[] args) throws java.lang.Exception
	{
        int t;
        BufferedInputStream in = new BufferedInputStream(System.in);
        t=in.read();
        for(int i=0;i<t;i++)
	   {
		   int n,q;
	       n=in.read();
	       q=in.read();
           int a[]=new int[n];
           for(int i1=0;i1<n;i1++)
	       {
		       a[i1]=in.read();
	       }
	       
	      for(int i1=0;i1<q;i1++)
	     {
	      int l,r;
	   	  l=in.read();
	   	  r=in.read();
	      l=l-1;
	      r=r-1;
	      int n1=n-(r-l)+1;
	      int b[]=new int[n1];
	     System.arraycopy(a,0,b,0,l-1);
	     System.arraycopy(a,r+1,b,l,n1);
	     int g;
	     g=b[0];
	     for(int i11=1;i11<n1;i11++)
	     {
	     	g=gcd(g,b[i11]);
	     }
	     //PrintWriter print = new PrintWriter(file);
	     PrintWriter pw = new PrintWriter(System.out, true);
         pw.println(g);

	     
	   } 
	 }
	}
  }
