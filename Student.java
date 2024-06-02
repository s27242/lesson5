import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;


public class Student {
    private String name;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private int semester;
    private String index;
    private StudyProgramme studyProgramme;
    private ArrayList<Grade> grades = new ArrayList<>();

    private static String generateIndex() {
        StringBuilder index = new StringBuilder("s");
        Random rd = new Random();
        for (int i = 0; i < 5; i++) {
            index.append(rd.nextInt(10));
        }
        return index.toString();
    }

    public Student(String name, String lastName, String email, String address, String phoneNumber, LocalDate dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.index = generateIndex();
    }

    public void enrollStudent(StudyProgramme it) {
        this.studyProgramme = it;
        this.semester = 1;
    }

    public void addGrade(int grate, String name) {
        Grade grade = new Grade(grate, name);
        this.grades.add(grade);
    }

    public String getStatus() {
        if (this.semester > 0) {
            return "kandydat";
    } else if (this.semester > 1) {
            return "student";
        } else if (this.semester > this.studyProgramme.getNumberOfSemesters()) {
            return "absolwent";
        }
        throw new IllegalStateException("Semester can't be negative");
    }

    private int getITN() {
        int count = 0;
        for (Grade grade : this.grades) {
            if (grade.getValue() < 3) {
                count++;
            }
        }
        return count;
    }

    public void promoteToNextSemester() {
        if (this.semester < this.studyProgramme.getNumberOfSemesters()) {
            this.semester++;
        } else if (this.getITN() > this.studyProgramme.getAllowedITN()) {
            throw new IllegalStateException("Semester can't be greater couse too many ITNs");
        } else {
            throw new IllegalStateException("Student already promoted");
        }
    }

    public String getInfo() {
        return "Name: " + this.name + " " + this.lastName + " email: " + this.email + " address: " + this.address + " phone number: " + this.phoneNumber + " date of birth: " + this.dateOfBirth + " semester: " + this.semester + " index: " + this.index + " status: " + this.getStatus();
    }
}
