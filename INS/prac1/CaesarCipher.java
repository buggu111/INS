import java.util.Scanner;

public class CaesarCipher {

    String message;
    static int key;

    static String encryptCaesar(String message1, int key1) {

        char ch;
        String encryptMessage = "";
        for (int i = 0; i < message1.length(); ++i) {
            ch = message1.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch + key1);

                if (ch > 'z') {
                    ch = (char) (ch - 'z' + 'a' - 1);
                }
                encryptMessage += ch;
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + key1);

                if (ch > 'Z') {
                    ch = (char) (ch - 'Z' + 'A' - 1);
                }
                encryptMessage += ch;
            } else {
                encryptMessage += ch;
            }

        }
        return encryptMessage;
    }

    static String descryptCeasar(String message1, int key1) {
        char ch;
        String decryptMessage = "";
        for (int i = 0; i < message1.length(); ++i) {
            ch = message1.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - key1);

                if (ch < 'a') {
                    ch = (char) (ch + 'z' - 'a' + 1);
                }
                decryptMessage += ch;
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch - key1);

                if (ch > 'A') {
                    ch = (char) (ch + 'Z' - 'A' + 1);
                }
                decryptMessage += ch;
            } else {
                decryptMessage += ch;
            }

        }
        return decryptMessage;
    }
    

    public static void main(String args[]) {
        String plainText;
        int key;
        String CipherText;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a message to encrypt: ");
        plainText = sc.nextLine();

        System.out.println("Enter key; ");
        key = sc.nextInt();
        CipherText = encryptCaesar(plainText, key);
        System.out.println("Cipher Text = " + CipherText);

        System.out.println("Original Text= " + descryptCeasar(CipherText, key));
    }

}