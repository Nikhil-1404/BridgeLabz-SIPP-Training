import java.util.Scanner;

public class NumberChecker {

    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }

    public static int[] getDigitsArray(int num) {
        String str = String.valueOf(num);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = Character.getNumericValue(str.charAt(i));
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int[] digits) {
        int sumSquares = 0;
        for (int d : digits) {
            sumSquares += Math.pow(d, 2);
        }
        return sumSquares;
    }

    public static boolean isHarshad(int num, int[] digits) {
        int sum = sumOfDigits(digits);
        return num % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
        }
        for (int d : digits) {
            freq[d][1]++;
        }
        return freq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = sc.nextInt();

        int count = countDigits(num);
        int[] digits = getDigitsArray(num);
        int sum = sumOfDigits(digits);
        int sumSquares = sumOfSquaresOfDigits(digits);
        boolean harshad = isHarshad(num, digits);
        int[][] freq = digitFrequency(digits);

        System.out.println("Count of digits: " + count);
        System.out.println("Digits: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println("\nSum of digits: " + sum);
        System.out.println("Sum of squares of digits: " + sumSquares);
        System.out.println("Is Harshad number: " + harshad);
        System.out.println("Digit Frequency: ");
        for (int i = 0; i < freq.length; i++) {
            if (freq[i][1] > 0) {
                System.out.println("Digit: " + freq[i][0] + " Frequency: " + freq[i][1]);
            }
        }
        sc.close();
    }
}
