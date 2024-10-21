import java.util.*;

public class Vernam{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter plain text: ");
        String plainText = sc.nextLine();

        char[] arText = plainText.toCharArray();

        System.err.println("Enter plain text: ");
        String key = sc.nextLine();

        char[] arkey = plainText.toCharArray();

        char[] cipherText = new char[plainText.length()]; 
        System.out.println("Encoded " + plainText + " to be..."); 

        for(int i = 0; i < arText.length; i++){
            cipherText[i] = (char) (arText[i] ^ arkey[i]);
            System.out.print(cipherText[i]);
        }

        System.out.println("\n");

        System.out.println("Decoded to be...");

        for(int i = 0; i < cipherText.length; i++){
            char temp = (char) (cipherText[i] ^ arkey[i]);
            System.out.print(temp);
        }
    }
}