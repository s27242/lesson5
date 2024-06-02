public class StudyProgramme {
    private String name;
    private String description;
    private int numberOfSemesters;
    private int allowedITN;

    public StudyProgramme(String name, String description, int numberOfSemesters, int allowedITN) {
        this.name = name;
        this.description = description;
        this.numberOfSemesters = numberOfSemesters;
        this.allowedITN = allowedITN;
    }

    public int getAllowedITN() {
        return this.allowedITN;
    }

    public int getNumberOfSemesters() {
        return this.numberOfSemesters;
    }

}
