import java.util.Random;

 class ZaraBonusCalculator {

    public static double[][] generateSalaryAndService(int numEmployees) {
        double[][] data = new double[numEmployees][2];
        Random rand = new Random();

        for (int i = 0; i < numEmployees; i++) {
            data[i][0] = 10000 + rand.nextInt(90000); // 5-digit salary
            data[i][1] = 1 + rand.nextInt(10); // 1 to 10 years of service
        }

        return data;
    }

    public static double[][] calculateBonusAndNewSalary(double[][] data) {
        double[][] result = new double[data.length][2];
        for (int i = 0; i < data.length; i++) {
            double salary = data[i][0];
            double years = data[i][1];
            double bonus = (years > 5) ? (salary * 0.05) : (salary * 0.02);
            double newSalary = salary + bonus;
            result[i][0] = newSalary;
            result[i][1] = bonus;
        }
        return result;
    }

    public static void displayResults(double[][] oldData, double[][] newData) {
        double totalOld = 0, totalNew = 0, totalBonus = 0;
        System.out.println("Emp\tOld Salary\tYears\tNew Salary\tBonus");
        for (int i = 0; i < oldData.length; i++) {
            System.out.printf("%d\t%.2f\t%.0f\t%.2f\t%.2f\n",
                (i + 1), oldData[i][0], oldData[i][1], newData[i][0], newData[i][1]);
            totalOld += oldData[i][0];
            totalNew += newData[i][0];
            totalBonus += newData[i][1];
        }
        System.out.println("--------------------------------------------");
        System.out.printf("Total Old Salary: %.2f\n", totalOld);
        System.out.printf("Total New Salary: %.2f\n", totalNew);
        System.out.printf("Total Bonus: %.2f\n", totalBonus);
    }

    public static void main(String[] args) {
        int numEmployees = 10;
        double[][] salaryAndService = generateSalaryAndService(numEmployees);
        double[][] bonusAndNewSalary = calculateBonusAndNewSalary(salaryAndService);
        displayResults(salaryAndService, bonusAndNewSalary);
    }
}
