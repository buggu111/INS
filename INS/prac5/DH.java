import java.util.*;

public class DH {
   public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter PRIME NUMBER 1 p:");
       int p =sc.nextInt();
       System.out.println("Enter PRIME NUMBER 2 g:");
       int g=sc.nextInt();
       System.out.println("Choose 1st secret no(Alice)'a':");
       int a= sc.nextInt();
       System.out.println("choose 2nd secret no(Bob)'b':");
       int b=sc.nextInt();
       
       int A=(int)Math.pow(g,a)%p;
       int B=(int)Math.pow(g, p)%p;
       
       System.out.println("public key of alice:"+A);
       System.out.println("Public key of Bob:"+B);
       
       int S_A = (int)Math.pow(B, a)% p;
       int S_B = (int)Math.pow(A,b)% p;
       
       System.out.println("Shared key of alice S_A:"+S_A);
       System.out.println("Shared key of Bob S_B:"+S_B);
       
       if(S_A == S_B){
           System.out.println("Alice and bob can communicate"+"with each other!!!");
           System.out.println("They share a secret no=" + S_A);
           
       }
       else{
           System.out.println("Alice and Bob cannot"+"communicate with each other!!!" );
       }
       
   } 
}