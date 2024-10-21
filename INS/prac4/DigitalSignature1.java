import java.security.*;
import java.util.Base64;

public class DigitalSignature1 {
    //Signing Algorithm
    private static final String SIGNING_ALGORITHM = "SHA256withRSA";
    private static final String RSA = "RSA";
    
    //Function to implement Digital signature using SHA256 and RSA algorithm by passing private key.
    public static byte[] Create_Digital_Signature(byte[] input, PrivateKey Key) throws Exception {
        Signature signature = Signature.getInstance(SIGNING_ALGORITHM);
        signature.initSign(Key);
        signature.update(input);
        return signature.sign();
    }
   
    //Generating the asymmetric key pair using SecureRandom class functions and RSA algorithm.
    public static KeyPair Generate_RSA_KeyPair() throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
        keyPairGenerator.initialize(2048, secureRandom);
        return keyPairGenerator.generateKeyPair();
    }
   
    //Function for Verification of the digital signature by using the public key
    public static boolean Verify_Digital_Signature(byte[] input, byte[] signatureToVerify, PublicKey key) throws Exception {
        Signature signature = Signature.getInstance(SIGNING_ALGORITHM);
        signature.initVerify(key);
        signature.update(input);
        return signature.verify(signatureToVerify);
    }
   
    //Driver code
    public static void main(String args[]) throws Exception {
        String input = "Good Morning";
        KeyPair keyPair = Generate_RSA_KeyPair();
       
        //Function Call
        byte[] signature = Create_Digital_Signature(input.getBytes(), keyPair.getPrivate());
        System.out.println("Signature Value (Base64):\n" + Base64.getEncoder().encodeToString(signature));
        System.out.println("Verification: " + Verify_Digital_Signature(input.getBytes(), signature, keyPair.getPublic()));
    }
}
