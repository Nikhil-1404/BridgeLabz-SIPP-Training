import java.time.LocalDate;
import java.util.*;

// -------------------- Policy Class --------------------
class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyholderName; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    public double getPremiumAmount() { return premiumAmount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate); // for TreeSet
    }

    @Override
    public String toString() {
        return "[" + policyNumber + ", " + policyholderName + ", " + expiryDate + ", " + coverageType + ", ₹" + premiumAmount + "]";
    }
}

// -------------------- Policy Manager --------------------
class PolicyManager {
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("All Unique Policies (HashSet):");
        hashSet.forEach(System.out::println);
    }

    public void displayExpiringSoon() {
        System.out.println("\nPolicies Expiring in Next 30 Days:");
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);
        treeSet.stream()
               .filter(p -> !p.getExpiryDate().isBefore(today) && !p.getExpiryDate().isAfter(threshold))
               .forEach(System.out::println);
    }

    public void displayByCoverageType(String type) {
        System.out.println("\nPolicies with Coverage Type '" + type + "':");
        hashSet.stream()
               .filter(p -> p.getCoverageType().equalsIgnoreCase(type))
               .forEach(System.out::println);
    }

    public void displayDuplicatePolicies(List<Policy> allPolicies) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (Policy p : allPolicies) {
            if (!seen.add(p.getPolicyNumber())) {
                duplicates.add(p.getPolicyNumber());
            }
        }

        if (duplicates.isEmpty()) {
            System.out.println("\nNo duplicate policies found.");
        } else {
            System.out.println("\nDuplicate Policy Numbers:");
            duplicates.forEach(System.out::println);
        }
    }

    public void performanceTest(List<Policy> policies) {
        Set<Policy> hSet = new HashSet<>();
        Set<Policy> lSet = new LinkedHashSet<>();
        Set<Policy> tSet = new TreeSet<>();

        long start, end;

        start = System.nanoTime();
        hSet.addAll(policies);
        end = System.nanoTime();
        System.out.println("\nHashSet insert time: " + (end - start) + " ns");

        start = System.nanoTime();
        lSet.addAll(policies);
        end = System.nanoTime();
        System.out.println("LinkedHashSet insert time: " + (end - start) + " ns");

        start = System.nanoTime();
        tSet.addAll(policies);
        end = System.nanoTime();
        System.out.println("TreeSet insert time: " + (end - start) + " ns");
    }
}

// -------------------- Main Class --------------------
public class InsurancePolicySystem {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        List<Policy> allPolicies = Arrays.asList(
            new Policy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 5000),
            new Policy("P102", "Bob", LocalDate.now().plusDays(45), "Auto", 3000),
            new Policy("P103", "Charlie", LocalDate.now().plusDays(20), "Home", 4000),
            new Policy("P104", "David", LocalDate.now().plusDays(5), "Health", 3500),
            new Policy("P101", "Alice-Duplicate", LocalDate.now().plusDays(15), "Health", 5000) // Duplicate
        );

        // Add to manager
        for (Policy p : allPolicies) {
            manager.addPolicy(p);
        }

        // Functionality
        manager.displayAllPolicies();
        manager.displayExpiringSoon();
        manager.displayByCoverageType("Health");
        manager.displayDuplicatePolicies(allPolicies);
        manager.performanceTest(allPolicies);
    }
}
