import java.util.Scanner;

public class YoungestTallestFriend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + friends[i] + ": ");
            ages[i] = scanner.nextInt();

            System.out.print("Enter height of " + friends[i] + ": ");
            heights[i] = scanner.nextDouble();
        }

        int youngestIndex = 0;
        int tallestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        System.out.println("The youngest is: " + friends[youngestIndex]);
        System.out.println("The tallest is: " + friends[tallestIndex]);

        scanner.close();
    }
}
