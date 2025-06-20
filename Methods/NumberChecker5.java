import java.util.Scanner;

public class NumberChecker5 {

    public static int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public static int[] getDigits(int num) {
        int count = countDigits(num);
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }

    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static boolean isPalindrome(int num) {
        int[] digits = getDigits(num);
        int[] reversed = reverseArray(digits);
        return compareArrays(digits, reversed);
    }

    public static boolean isDuckNumber(int num) {
        int[] digits = getDigits(num);
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int count = countDigits(num);
        int[] digits = getDigits(num);
        int[] reversed = reverseArray(digits);
        boolean same = compareArrays(digits, reversed);
        boolean palindrome = isPalindrome(num);
        boolean duck = isDuckNumber(num);

        System.out.println("Count of Digits: " + count);

        System.out.print("Digits: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println();

        System.out.print("Reversed Digits: ");
        for (int r : reversed) System.out.print(r + " ");
        System.out.println();

        System.out.println("Are original and reversed arrays equal? " + same);
        System.out.println("Is Palindrome Number? " + palindrome);
        System.out.println("Is Duck Number? " + duck);

        sc.close();
    }
}
