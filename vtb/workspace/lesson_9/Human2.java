package vtb.workspace.lesson_9;

/**
 * @author Mikhail Zaitsev
 */
public class Human2 {
    @PrivateField
    private String name;
    @PublicField
    public Integer age;
    @PublicField
    public Integer age2 = 15;
    @PrivateField
    public String test = "10";

    @Constructor
    public Human2(String name,int age){
        this.name = name;
        this.age = age;
    }
    @PrivateGetter
    private String getName(){
        return name;
    }
    @Getter
    public int getAge(){
        return age;
    }
    @Getter
    public int getAge2(){
        return age2;
    }
}
