package ex3;

public class Student extends Human {
    private String facultyNum;

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Student(String firstName, String lastName, String facultyNum) {
        super(firstName, lastName);

        setFacultyNum(facultyNum);
    }

    public String getFacultyNum() {
        return facultyNum;
    }

    public void setFacultyNum(String facultyNum) {
        if (facultyNum.length() < 5 || facultyNum.length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNum = facultyNum;
    }

    @Override
    public String toString() {
        return super.toString() +"\nFacultyNum: " + facultyNum;
    }

}
