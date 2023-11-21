import zoo.Animal;

public class Bird extends Animal {
    public Bird(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void breed() {}
}

