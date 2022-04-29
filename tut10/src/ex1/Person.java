package ex1;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name)throws IllegalArgumentException {
        if (name.length()<3)
            throw new IllegalArgumentException("Name cannot be less than 3!");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    protected void setAge(int age) throws IllegalArgumentException {
        if (age < 1)
            throw new IllegalArgumentException("Age must be positive!");
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s, Age: %d",
                this.getName(),
                this.getAge()));
        return sb.toString();
    }
}
