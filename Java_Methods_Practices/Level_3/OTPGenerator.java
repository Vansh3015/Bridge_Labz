import java.util.HashSet;
import java.util.Random;

public class OTPGenerator {

    public static int generateOTP() {
        Random r = new Random();
        return 100000 + r.nextInt(900000); // 6-digit
    }

    public static boolean uniqueOTPs(int[] arr) {
        HashSet<Integer> s = new HashSet<>();
        for (int v : arr) s.add(v);
        return s.size() == arr.length;
    }

    public static void demo() {
        int[] otps = new int[10];
        for (int i = 0; i < 10; i++) otps[i] = generateOTP();
        System.out.println("OTPs: ");
        for (int v : otps) System.out.println(v);
        System.out.println("Unique? " + uniqueOTPs(otps));
    }
}
