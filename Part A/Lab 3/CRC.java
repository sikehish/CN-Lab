import java.util.Scanner;

public class CRC {
    public static String crc(String data, String poly, boolean errChk) {
        String rem = data;
    
        if (!errChk) {
            for (int i = 0; i < poly.length() - 1; i++) {
                rem += "0";
            }
        }
    
        for (int i = 0; i < data.length(); i++) {
            if (rem.charAt(i) == '1') {
                String temp = "";
                for (int j = 0; j < poly.length(); j++) {
                    temp += (rem.charAt(i + j) == poly.charAt(j)) ? '0' : '1';
                }
                System.out.println("HAHAH: "+ temp);
                rem = rem.substring(0, i) + temp + rem.substring(i + poly.length());
            }
        }
    
        return rem.substring(rem.length() - poly.length() + 1);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data, poly;

        System.out.print("Enter key/polynomial: ");
        poly = scanner.next();

        System.out.print("Enter Data to be sent: ");
        data = scanner.next();

        String rem = crc(data, poly, false);
        String codeword = data + rem;

        System.out.println("Remainder: " + rem);
        System.out.println("Codeword: " + codeword);

        // Checking error
        String recvCodeword;
        System.out.print("Enter received codeword: ");
        recvCodeword = scanner.next();

        String recvRem = crc(recvCodeword, poly, true);

        if (Integer.parseInt(recvRem, 2) == 0) {
            System.out.println("No Error");
        } else {
            System.out.println("Error Detected");
        }

        scanner.close();
    }
}
