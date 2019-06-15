package DemoProj;

import java.util.Scanner;

public class GreatestArrayEle {

	public static void main(String[] args) 
	{
             Scanner sc = new Scanner(System.in);
             System.out.println("enter the array element");
             int n = sc.nextInt();
             int arr[] = new int[n];
             System.out.println("enter the array element");
             for(int i=0;i<n;i++)
             {
            	
            	 arr[i]= sc.nextInt();
             }
             int gr = arr[0];
             for(int i=1;i<n;i++)
             {
               if(gr<arr[i])
               {
            	   gr = arr[i];
               }
             }
     
             System.out.println("Greatest element is ="+gr);
	}

}
