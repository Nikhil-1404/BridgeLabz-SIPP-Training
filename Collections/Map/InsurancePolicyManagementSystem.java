import java.time.LocalDate;
import java.util.*;

// Policy class
class Policy {
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

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "[" + policyNumber + ", " + policyholderName + ", " + expiryDate + ", " + coverageType + ", ₹" + premiumAmount + "]";
    }
}

// Insurance Policy Manager
class InsurancePolicyManager {
    Map<String, Policy> hashMap = new HashMap<>();
    Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    TreeMap<LocalDate, List<Policy>> expiryDateMap = new TreeMap<>();

    // Add policy
    public void addPolicy(Policy policy) {
        hashMap.put(policy.getPolicyNumber(), policy);
        linkedHashMap.put(policy.getPolicyNumber(), policy);
        expiryDateMap.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    // Retrieve by policy number
    public Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    // Policies expiring in next 30 days
    public List<Policy> getPoliciesExpiringInNext30Days() {
        List<Policy> result = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);
        expiryDateMap.subMap(today, true, limit, true)
                     .values()
                     .forEach(result::addAll);
        return result;
    }

    // Policies by policyholder name
    public List<Policy> getPoliciesByPolicyholder(String name) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : hashMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(name)) {
                result.add(policy);
            }
        }
        return result;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        Iterator<Map.Entry<String, Policy>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Policy> entry = it.next();
            if (entry.getValue().getExpiryDate().isBefore(today)) {
                linkedHashMap.remove(entry.getKey());
                it.remove();
            }
        }

        expiryDateMap.headMap(today, false).clear();
    }

    // Print all policies in insertion order
    public void printAllPolicies() {
        System.out.println("All Policies (Insertion Order):");
        for (Policy policy : linkedHashMap.values()) {
            System.out.println(policy);
        }
    }
}

// Main class to test
public class InsurancePolicyManagementSystem {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Add sample policies
        manager.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(10), "Health", 5200));
        manager.addPolicy(new Policy("P1002", "Bob", LocalDate.now().plusDays(45), "Auto", 3100));
        manager.addPolicy(new Policy("P1003", "Alice", LocalDate.now().minusDays(3), "Home", 2750));
        manager.addPolicy(new Policy("P1004", "Charlie", LocalDate.now().plusDays(20), "Life", 6300));

        // Display all policies
        manager.printAllPolicies();

        // Retrieve specific policy
        System.out.println("\nPolicy P1002 Details:");
        System.out.println(manager.getPolicyByNumber("P1002"));

        // Policies expiring in next 30 days
        System.out.println("\nPolicies expiring within 30 days:");
        for (Policy p : manager.getPoliciesExpiringInNext30Days()) {
            System.out.println(p);
        }

        // Policies for a specific policyholder
        System.out.println("\nPolicies for Alice:");
        for (Policy p : manager.getPoliciesByPolicyholder("Alice")) {
            System.out.println(p);
        }

        // Remove expired policies
        System.out.println("\nRemoving expired policies...");
        manager.removeExpiredPolicies();
        manager.printAllPolicies();
    }
}
