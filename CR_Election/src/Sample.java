import java.util.ArrayList;

class Student {
    private String name, branch, course, section, registrationNumber;
    private double GPA;
    private int year;
    private boolean isHosteller;

    public Student(String name, String branch, String course, String section, boolean isHosteller, double GPA, int year, String registrationNumber) {
        this.name = name;
        this.branch = branch;
        this.course = course;
        this.section = section;
        this.isHosteller = isHosteller;
        this.GPA = GPA;
        this.year = year;
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public String getCourse() {
        return course;
    }

    public String getSection() {
        return section;
    }

    public boolean getResidence() {
        return isHosteller;
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

class QualifyingStudent extends Student {

    private boolean isQualifying;
    private int voteCount;

    public QualifyingStudent(String name, String branch, String course, String section, boolean isHosteller, double GPA, int year, String registrationNumber, boolean isQualifying, int voteCount) {
        super(name, branch, course, section, isHosteller, GPA, year, registrationNumber);
        this.isQualifying = isQualifying;
        this.voteCount = voteCount;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(
                new Student(
                        "Somil", "CCE", "B.Tech", "A", true, 9.1, 3, "199303011"
                )
        );
        studentList.add(
                new Student(
                        "Hardik", "CCE", "B.Tech", "A", true, 8.6, 3, "199303069"
                )
        );
        studentList.add(
                new Student(
                        "Auli", "CCE", "B.Tech", "A", true, 6.3, 3, "199303055"
                )
        );
        studentList.add(
                new Student(
                        "Tanishka", "CCE", "B.Tech", "A", false, 8.5, 3, "199303001"
                )
        );
        studentList.add(
                new Student(
                        "Kartik", "CCE", "B.Tech", "A", true, 8.1, 3, "199303022"
                )
        );
    }
}