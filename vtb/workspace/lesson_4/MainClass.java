package vtb.workspace.lesson_4;

public class MainClass {
    public static void main(String[] args) {
        Box<Fruit> appleBox = new Box<>();
        Box<Fruit> appleBox2 = new Box<>();
        Box<Fruit> orangeBox = new Box<>();

        for (int i = 0; i < 5; i++) {
            appleBox.put(new Apple());
        }
        for (int i = 0; i < 5; i++) {
            appleBox2.put(new Apple());
        }
        for (int i = 0; i < 5; i++) {
            orangeBox.put(new Orange());
        }

        appleBox.compare(appleBox2);
        orangeBox.compare(appleBox2);
        appleBox.replace(orangeBox);
        appleBox2.replace(appleBox);
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox2.getWeight());
        appleBox.replace(appleBox2);
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox2.getWeight());
        orangeBox.compare(appleBox2);

    }
}
