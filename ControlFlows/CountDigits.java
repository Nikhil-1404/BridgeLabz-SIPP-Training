public class CountDigits {
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);
        int count = 0;

        if (number == 0) {
            count = 1;
        } else {
            while (number != 0) {
                number = number / 10;
                count++;
            }
        }

        System.out.println("Number of digits: " + count);
    }
}
