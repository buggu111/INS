import java.security.*;
import java.util.Base64;

public class Digital_Signature {
    
    // Signing Algorithm
    private static final String SIGNING_ALGORITHM = "SHA256withRSA";
    private static final String RSA = "RSA";
    
    // Function to create Digital Signature using SHA256 and RSA algorithm by passing private key
    public static byte[] create_Digital_Signature(byte[] input, PrivateKey key) throws Exception {
        Signature signature = Signature.getInstance(SIGNING_ALGORITHM);
        signature.initSign(key);
        signature.update(input);
        return signature.sign();
    }
    
    // Generate RSA Key Pair
    public static KeyPair Generate_RSA_KeyPair() throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
        keyPairGenerator.initialize(2048, secureRandom);
        return keyPairGenerator.generateKeyPair();
    }
    
    // Function to verify the digital signature using the public key
    public static boolean Verify_Digital_Signature(byte[] input, byte[] signatureToVerify, PublicKey key) throws Exception {
        Signature signature = Signature.getInstance(SIGNING_ALGORITHM);
        signature.initVerify(key);
        signature.update(input);
        return signature.verify(signatureToVerify);
    }
    
    // Driver code
    public static void main(String[] args) throws Exception {
        String input = "Good Morning";
        KeyPair keyPair = Generate_RSA_KeyPair();
        
        // Create digital signature
        byte[] signature = create_Digital_Signature(input.getBytes(), keyPair.getPrivate());
        
        // Print signature in Base64 format
        System.out.println("Signature Value (Base64):\n" + Base64.getEncoder().encodeToString(signature));
        
        // Verify the signature
        System.out.println("Verification: " + Verify_Digital_Signature(input.getBytes(), signature, keyPair.getPublic()));
    }
}
