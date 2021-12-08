import java.util.ArrayList;

//public class CRUtil {
//    private final double GPA_CRITERIA = 8.5;
//
//    ArrayList<QualifyingStudent> findQualifyingStudents(ArrayList<Student> students) {
//        ArrayList<QualifyingStudent> qualifyingStudent = new ArrayList<>();
//        for (int i = 0; i < students.size(); i++) {
//            Student temp = students.get(i);
//            if (temp.getGPA() >= GPA_CRITERIA) {
//                qualifyingStudent.add(new QualifyingStudent(temp, 0));
//            }
//        }
//        return qualifyingStudent;
//    }
//
//    QualifyingStudent findCR(ArrayList<QualifyingStudent> students) {
//        int maxValue = -1;
//        QualifyingStudent maxStudent = students.get(0);
//        for (int i = 0; i < students.size(); i++) {
//            QualifyingStudent temp = students.get(i);
//            if (temp.getVotes() > maxValue) {
//                maxValue = temp.getVotes();
//                maxStudent = temp;
//            }
//        }
//        return maxStudent;
//    }
//}
