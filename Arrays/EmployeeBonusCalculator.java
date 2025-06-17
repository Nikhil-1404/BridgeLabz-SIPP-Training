import java.util.Scanner;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int EMPLOYEE_COUNT = 10;

        double[] salaries = new double[EMPLOYEE_COUNT];
        int[] yearsOfService = new int[EMPLOYEE_COUNT];
        double[] bonusAmounts = new double[EMPLOYEE_COUNT];
        double[] newSalaries = new double[EMPLOYEE_COUNT];

        double totalOldSalary = 0;
        double totalBonus = 0;
        double totalNewSalary = 0;

        // Take input for salary and years of service for each employee
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");

            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();
            if (salary <= 0) {
                System.out.println("Invalid salary. Please enter again.");
                i--;
                continue;
            }

            System.out.print("Enter years of service: ");
            int years = scanner.nextInt();
            if (years < 0) {
                System.out.println("Invalid years of service. Please enter again.");
                i--;
                continue;
            }

            salaries[i] = salary;
            yearsOfService[i] = years;
        }

        // Calculate bonus, new salary and totals
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            double bonusRate = yearsOfService[i] > 5 ? 0.05 : 0.02;
            double bonus = salaries[i] * bonusRate;
            double newSalary = salaries[i] + bonus;

            bonusAmounts[i] = bonus;
            newSalaries[i] = newSalary;

            totalOldSalary += salaries[i];
            totalBonus += bonus;
            totalNewSalary += newSalary;
        }

        // Display results
        System.out.println("\n--- Employee Bonus Details ---");
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.printf("Employee %d: Old Salary = %.2f, Bonus = %.2f, New Salary = %.2f%n",
                    (i + 1), salaries[i], bonusAmounts[i], newSalaries[i]);
        }

        System.out.println("\nTotal old salary of all employees: " + totalOldSalary);
        System.out.println("Total bonus payout: " + totalBonus);
        System.out.println("Total new salary of all employees: " + totalNewSalary);

        scanner.close();
    }
}
