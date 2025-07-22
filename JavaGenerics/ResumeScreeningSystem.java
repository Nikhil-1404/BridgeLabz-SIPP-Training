import java.util.*;

// ---------- Abstract Class for Job Roles ----------
abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public abstract void evaluateResume();
}

// ---------- Subclasses for Specific Roles ----------
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    @Override
    public void evaluateResume() {
        System.out.println(getCandidateName() + ": Evaluated for Software Engineer - Focus on coding skills & system design.");
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }

    @Override
    public void evaluateResume() {
        System.out.println(getCandidateName() + ": Evaluated for Data Scientist - Focus on statistics, ML, and data analysis.");
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }

    @Override
    public void evaluateResume() {
        System.out.println(getCandidateName() + ": Evaluated for Product Manager - Focus on strategy, communication, and UX.");
    }
}

// ---------- Generic Resume Class ----------
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void process() {
        System.out.println("Processing resume of " + jobRole.getCandidateName() + "...");
        jobRole.evaluateResume();
    }
}

// ---------- Generic Method & Wildcard Utility ----------
class ResumeProcessor {
    public static <T extends JobRole> Resume<T> generateResume(T jobRole) {
        return new Resume<>(jobRole);
    }

    public static void screenMultipleResumes(List<? extends JobRole> roles) {
        System.out.println("\n--- Screening Multiple Resumes ---");
        for (JobRole role : roles) {
            role.evaluateResume();
        }
    }
}

// ---------- Main Class ----------
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        // Individual candidates
        SoftwareEngineer se = new SoftwareEngineer("Alice");
        DataScientist ds = new DataScientist("Bob");
        ProductManager pm = new ProductManager("Charlie");

        // Generate resumes using generic method
        Resume<SoftwareEngineer> seResume = ResumeProcessor.generateResume(se);
        Resume<DataScientist> dsResume = ResumeProcessor.generateResume(ds);
        Resume<ProductManager> pmResume = ResumeProcessor.generateResume(pm);

        // Process each resume individually
        System.out.println("----- Individual Resume Processing -----");
        seResume.process();
        dsResume.process();
        pmResume.process();

        // Batch screening using wildcard method
        List<JobRole> applicants = new ArrayList<>();
        applicants.add(se);
        applicants.add(ds);
        applicants.add(pm);

        ResumeProcessor.screenMultipleResumes(applicants);
    }
}
