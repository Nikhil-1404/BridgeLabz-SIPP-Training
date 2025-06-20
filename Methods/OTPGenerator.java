import java.util.HashSet;

public class OTPGenerator {

    // Method to generate a 6-digit OTP
    public static int generateOTP() {
        // Math.random() generates [0,1); multiply by 900000 and add 100000 to get 100000–999999
        return (int)(Math.random() * 900000) + 100000;
    }

    // Method to generate 10 OTPs and store in an array
    public static int[] generateMultipleOTPs(int count) {
        int[] otps = new int[count];
        for (int i = 0; i < count; i++) {
            otps[i] = generateOTP();
        }
        return otps;
    }

    // Method to check if all OTPs are unique
    public static boolean areOTPsUnique(int[] otps) {
        HashSet<Integer> uniqueOTPs = new HashSet<>();
        for (int otp : otps) {
            if (!uniqueOTPs.add(otp)) {
                return false; // Duplicate found
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = generateMultipleOTPs(10);

        System.out.println("Generated OTPs:");
        for (int otp : otps) {
            System.out.println(otp);
        }

        boolean unique = areOTPsUnique(otps);
        System.out.println("\nAre all OTPs unique? " + unique);
    }
}
