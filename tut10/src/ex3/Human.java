package ex3;

public class Human {
    private String firstName;
    private String lastName;
    public Human(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        if (firstName.charAt(0)<'A'||firstName.charAt(0)>'Z') {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if (firstName.length()<4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        if (lastName.charAt(0)<'A'||lastName.charAt(0)>'Z') {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if (lastName.length()<3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "First Name: " + firstName + "\nLast Name: " + lastName;
    }

}
