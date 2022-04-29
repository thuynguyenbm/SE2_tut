package ex1;

public class Child extends Person{
    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) throws IllegalArgumentException {
        if (age>15) throw new IllegalArgumentException("Child's age cannot be greater than 15");
        super.setAge(age);
    }
}
