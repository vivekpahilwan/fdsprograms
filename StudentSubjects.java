import java.util.HashSet;
import java.util.Set;

class StudentSubjects {
    public static void main(String[] args) {

        // Create 3 sets of mathlovers , sciencelovers , bothlovers
        // using Set class
        Set<String> mathLovers = new HashSet<>();
        Set<String> scienceLovers = new HashSet<>();
        Set<String> bothLovers = new HashSet<>();

        // Populate the sets with student names and their preferences
        mathLovers.add("S1");
        mathLovers.add("S2");
        bothLovers.add("S3");
        scienceLovers.add("S4");
        bothLovers.add("S5");
        mathLovers.add("S6");

        // Find students who like Math only (M - MnS)
        Set<String> mathOnly = new HashSet<>(mathLovers);
        mathOnly.removeAll(bothLovers);

        // Find students who like Science only (S - MnS)
        Set<String> scienceOnly = new HashSet<>(scienceLovers);
        scienceOnly.removeAll(bothLovers);

        // Find students who like either Math or Science (MuS)
        Set<String> eitherMathOrScience = new HashSet<>();
        eitherMathOrScience.addAll(mathLovers);
        eitherMathOrScience.addAll(scienceLovers);

        System.out.println("Students who like Math only: " + mathOnly + "\n");
        System.out.println("Students who like Science only: " + scienceOnly + "\n");
        System.out.println("Students who like either Math or Science: " + eitherMathOrScience);
    }
}
