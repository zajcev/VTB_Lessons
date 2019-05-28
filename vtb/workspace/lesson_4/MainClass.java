package vtb.workspace.lesson_4;

public class MainClass {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>(new Apple());
        Box<Apple> appleBox2 = new Box<>(new Apple());
        Box<Orange> orangeBox = new Box<>(new Orange());

        appleBox.put(new Apple());
        appleBox2.put(new Apple());
        appleBox.replace(appleBox2);
        System.out.println(appleBox.compare(orangeBox));
        System.out.println(appleBox.compare(appleBox2));

    }
}
