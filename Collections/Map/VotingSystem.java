import java.util.*;

public class VotingSystem {
    private HashMap<String, Integer> voteCountMap = new HashMap<>();
    private LinkedHashMap<Integer, String> voteLog = new LinkedHashMap<>();
    private int voteId = 1;

    // Cast a vote
    public void castVote(String candidate) {
        // Store in HashMap
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);

        // Store in LinkedHashMap (ordered vote log)
        voteLog.put(voteId++, candidate);
    }

    // Show results in alphabetical order using TreeMap
    public void displayResultsSorted() {
        System.out.println("Sorted Results (by Candidate):");
        TreeMap<String, Integer> sorted = new TreeMap<>(voteCountMap);
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue() + " vote(s)");
        }
    }

    // Show all votes cast in order using LinkedHashMap
    public void displayVoteLog() {
        System.out.println("Vote Log (order of casting):");
        for (Map.Entry<Integer, String> entry : voteLog.entrySet()) {
            System.out.println("Vote #" + entry.getKey() + " → " + entry.getValue());
        }
    }

    // Show current vote counts (unordered)
    public void displayRawVoteCount() {
        System.out.println("Raw Vote Count (HashMap):");
        for (Map.Entry<String, Integer> entry : voteCountMap.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }

    // Main method
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        // Simulate votes
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("David");
        system.castVote("Bob");
        system.castVote("Alice");

        // Show all outputs
        system.displayVoteLog();
        System.out.println();
        system.displayRawVoteCount();
        System.out.println();
        system.displayResultsSorted();
    }
}
