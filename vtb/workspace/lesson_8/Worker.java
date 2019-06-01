package vtb.workspace.lesson_8;

/**
 * @author Mikhail Zaitsev
 */

public class Worker {
    String name;
    int age;
    int salary;

    public Worker(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    protected int getSalary(){
        return salary;
    }
    protected int getAge(){
        return age;
    }
    protected String getName(){
        return name;
    }

}
