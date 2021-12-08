import java.util.ArrayList;

public class CRUtils {

    private static final double GPA_CRITERIA = 8.5;

    // Finds a CR from a qualifying list of students
    public static ArrayList<QualifyingStudent> findCR(ArrayList<QualifyingStudent> students) {
        ArrayList<QualifyingStudent> selected = new ArrayList<>();
        for (QualifyingStudent std : students) {
            if (std.component1().getGPA() >= GPA_CRITERIA) {
                selected.add(std);
            }
        }
        return selected;
    }
}
