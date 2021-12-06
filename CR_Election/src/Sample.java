class Student {
    private String name, branch, course, section, residence, registrationNumber;
    private double GPA;
    private int year;

    public Student(String name, String branch, String course, String section, String residence, double GPA, int year, String registrationNumber) {
        this.name = name;
        this.branch = branch;
        this.course = course;
        this.section = section;
        this.residence = residence;
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

    public String getResidence() {
        return residence;
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

    public QualifyingStudent(String name, String branch, String course, String section, String residence, double GPA, int year, String registrationNumber, boolean isQualifying, int voteCount) {
        super(name, branch, course, section, residence, GPA, year, registrationNumber);
        this.isQualifying = isQualifying;
        this.voteCount = voteCount;
    }
}
