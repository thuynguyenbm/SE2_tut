package to_dos.factory;

// Create the Computer class that extends Course abstract class 
class Computer extends Course {
	// TO-DO: Implement getDuration() method: set a specific duration and print value
	public void getDuration() {
		this.duration = 2;
		System.out.println("The duration of Computer Course is: " + duration);
	}

	// TO-DO: Implement getFeePerSemester() method: set a specific fee and print value
	public void getFeePerSemester() {
		this.fee = 200;
		System.out.println("The fee of Computer Course per semester is: " + fee);
	}
} 
