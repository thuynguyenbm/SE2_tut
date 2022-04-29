package to_do;

public class BagTest {
    public static void main(String[] args) {
        BagInterface<String> sports = new ArrayBag<String>();
        System.out.println("Initial size: " + sports.getCurrentSize()); // return 0
        sports.add("Football");
        sports.add("Badminton");
        System.out.println("Index of Badminton: " + ((ArrayBag<String>) sports).getIndexOf("Badminton")); //return 1
        System.out.println("Current size: " + sports.getCurrentSize()); // return 2
        sports.remove("Badminton");
        System.out.println("Current size: " + sports.getCurrentSize()); // return 1
        System.out.println("Frequency of Football: " + sports.getFrequencyOf("Football")); // return 1
        sports.add("Football");
        System.out.println("Frequency of Football: " + sports.getFrequencyOf("Football")); // return 2
        ((ArrayBag<String>) sports).removeEntry(1);
        System.out.println("Frequency of Football: " + sports.getFrequencyOf("Football")); // return 1
        sports.clear();
        System.out.println("Initial size: " + sports.getCurrentSize()); // return 0

    }
}
