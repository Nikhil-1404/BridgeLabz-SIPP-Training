public class CircularTour {

    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0, balance = 0, deficit = 0;

        for (int i = 0; i < n; i++) {
            balance += pumps[i].petrol - pumps[i].distance;

            if (balance < 0) {
                // Cannot reach next pump, try next as start
                start = i + 1;
                deficit += balance;
                balance = 0;
            }
        }

        if (balance + deficit >= 0)
            return start;
        else
            return -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };

        int result = findStartingPoint(pumps);

        if (result != -1)
            System.out.println("Start at petrol pump index: " + result);
        else
            System.out.println("No solution exists.");
    }
}
