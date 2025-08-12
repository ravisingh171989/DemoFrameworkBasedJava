package Tests;

import java.util.*;

public class primeNumbers {
   public static void main (String[] args){
	   Scanner scan = new Scanner(System.in);
	   int num = scan.nextInt();
       String  primeNumbers = "";
       for(int i = 1; i <= num; i++) { 		  	  
          int counter=0; 	  
          for(int j =i; j>=1; j--) {
             if(i%j==0) {
                 counter += 1;
             }
          }
          if (counter ==2) {
              primeNumbers = primeNumbers + i + " ";
          }	
       }	
       System.out.println("Prime numbers from 1 to 100 are :");
       System.out.println(primeNumbers);
   }
}
