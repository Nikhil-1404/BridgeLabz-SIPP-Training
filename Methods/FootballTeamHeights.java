import java.util.Random;

public class FootballTeamHeights {

    // Method to generate random heights between 150 and 250 cm
    public static int[] generateHeights(int size) {
        int[] heights = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            heights[i] = rand.nextInt(101) + 150; // 150 to 250
        }
        return heights;
    }

    // Method to find sum of heights
    public static int sumOfHeights(int[] heights) {
        int sum = 0;
        for (int h : heights) {
            sum += h;
        }
        return sum;
    }

    // Method to find mean height
    public static double meanHeight(int[] heights) {
        int sum = sumOfHeights(heights);
        return (double) sum / heights.length;
    }

    // Method to find shortest height
    public static int shortestHeight(int[] heights) {
        int min = heights[0];
        for (int h : heights) {
            if (h < min) {
                min = h;
            }
        }
        return min;
    }

    // Method to find tallest height
    public static int tallestHeight(int[] heights) {
        int max = heights[0];
        for (int h : heights) {
            if (h > max) {
                max = h;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = generateHeights(11);

        System.out.print("Player Heights (in cm): ");
        for (int h : heights) {
            System.out.print(h + " ");
        }
        System.out.println();

        int sum = sumOfHeights(heights);
        double mean = meanHeight(heights);
        int shortest = shortestHeight(heights);
        int tallest = tallestHeight(heights);

        System.out.println("\nTotal Sum of Heights: " + sum + " cm");
        System.out.printf("Mean Height: %.2f cm%n", mean);
        System.out.println("Shortest Height: " + shortest + " cm");
        System.out.println("Tallest Height: " + tallest + " cm");
    }
}
