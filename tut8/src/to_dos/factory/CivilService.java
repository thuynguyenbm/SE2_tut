package to_dos.factory;

// Create the CivilService class that extends Course abstract class 
class CivilService extends Course {
    // TO-DO: Implement getDuration() method: set a specific duration and print value
    public void getDuration() {
        this.duration = 5;
        System.out.println("The duration of Civil Service Course is: " + duration);
    }

    // TO-DO: Implement getFeePerSemester() method: set a specific fee and print value
    public void getFeePerSemester() {
        this.fee = 500;
        System.out.println("The fee of Civil Service Course per semester is: " + fee);
    }
}