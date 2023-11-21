public class Animal {
    private int numberOfLegs;
    private int numberOfEyes;
    private String name;

    public Animal(int numberOfLegs, int numberOfEyes, String name) {
        this.numberOfLegs = numberOfLegs;
        this.numberOfEyes = numberOfEyes;
        this.name = name;
    }

    public void printAnimal() {
        System.out.println("Állat neve: " + name);
        System.out.println("Lábak száma: " + numberOfLegs);
        System.out.println("Szemek száma: " + numberOfEyes);
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public int getNumberOfEyes() {
        return numberOfEyes;
    }

    public String getName() {
        return name;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public void setNumberOfEyes(int numberOfEyes) {
        this.numberOfEyes = numberOfEyes;
    }

    public void setName(String name) {
        this.name = name;
    } 

    public static void main(String[] args) {
        Animal animal = new Animal(4, 2, "Dog");
        animal.printAnimal();
    }
}