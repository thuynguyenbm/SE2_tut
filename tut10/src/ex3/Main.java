package ex3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student info: ");
        String stdInfo = sc.nextLine();
        String regex = "([a-zA-Z0-9]*) ([a-zA-Z0-9]*) ([0-9]*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stdInfo);
        matcher.find();
        String stdFirstName = matcher.group(1);
        String stdLastName = matcher.group(2);
        String facultyNum = matcher.group(3);


        Student student = new Student(stdFirstName, stdLastName, facultyNum);
        System.out.println("Enter worker info: ");

        String wInfo = sc.nextLine();
        regex = "([a-zA-Z0-9]*) ([a-zA-Z0-9]*) ([0-9.]*) ([0-9]*)";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(wInfo);
        matcher.find();
        String wFirstName = matcher.group(1);
        String wLastName = matcher.group(2);
        double weekSalary = Double.parseDouble(matcher.group(3));
        int workingHours = Integer.parseInt(matcher.group(4));

        Worker worker = new Worker(wFirstName, wLastName, weekSalary, workingHours);

        System.out.println(student.toString());
        System.out.println("============================");
        System.out.println(worker.toString());

    }
}
