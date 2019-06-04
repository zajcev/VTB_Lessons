package vtb.workspace.lesson_9;

/**
 * @author Mikhail Zaitsev
 */
public class Human{
    @PrivateField
    private String name;
    @PublicField
    public Integer age;

    @Constructor
    public Human(String name,int age){
        this.name = name;
        this.age = age;
    }
    @PrivateGetter
    private String getName(){
        return name;
    }
    @Getter
    public  int getAge(){
        return age;
    }

}
