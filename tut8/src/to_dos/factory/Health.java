package to_dos.factory;

// Creating the Health class that extends Course abstract class 
class Health extends Course {
	// TO-DO: Implement getDuration() method: set a specific duration and print value
	public void getDuration() {
		this.duration = 4;
		System.out.println("The duration of Health Course is: " + duration);
	}

	// TO-DO: Implement getFeePerSemester() method: set a specific fee and print value
	public void getFeePerSemester() {
		this.fee = 250;
		System.out.println("The fee of Health Course per semester is: " + fee);
	}
}// end of Health class.