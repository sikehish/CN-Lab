import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class RSA {

    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;

    public RSA(int bitLength) {
        generateKeyPairs(bitLength);
    }

    private void generateKeyPairs(int bitLength) {
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(bitLength, random);
        BigInteger q = BigInteger.probablePrime(bitLength, random);

        modulus = p.multiply(q);

        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        publicKey = new BigInteger("65537"); // Commonly used public exponent
        privateKey = publicKey.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger message) {
        return message.modPow(publicKey, modulus);
    }

    public BigInteger decrypt(BigInteger encryptedMessage) {
        return encryptedMessage.modPow(privateKey, modulus);
    }

    public static void main(String[] args) {
        int bitLength = 1024;
        String originalMessage;
        Scanner sc=new Scanner(System.in);

        RSA rsa = new RSA(bitLength);

        System.out.print("Enter a string: ");
        originalMessage=sc.nextLine();

        BigInteger message = new BigInteger(originalMessage.getBytes());

        BigInteger encryptedMessage = rsa.encrypt(message);
        System.out.println("Encrypted message: " + encryptedMessage);

        BigInteger decryptedMessage = rsa.decrypt(encryptedMessage);
        System.out.println("Decrypted message: " + new String(decryptedMessage.toByteArray()));
    }
}


// Output 
// Enter a string: Hi I am Hisham
// Encrypted message: 10365988828612849972949436812100863110687643054851274454592305819297960894211366371150428108145561472906016590714562575158416260764996873599308514248228248352667803306207078393803947719196035444400918635841382570952092396721827268118041367712761966913951669038094724335525471474847840503086703842508846043038805496242001346171346985945743841790665517087181525682136266282291982472549137896363990515617141472300805040008391814384080556649571344308463018981319322066436650241409057470506612257953197083073565537741191229671458871630418294180981628868678266572792367632926411505670630267646075430667196593113851414373764
// Decrypted message: Hi I am Hisham