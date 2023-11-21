import java.util.Scanner;

public class Cuboid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("cuboid hosszúsága: ");
        double length = scanner.nextDouble();

        System.out.print("cuboid szélessége: ");
        double width = scanner.nextDouble();

        System.out.print("cuboid magassága: ");
        double height = scanner.nextDouble();

        double surfaceArea = 2 * (length * width + length * height + width * height);

        double volume = length * width * height;

        System.out.println("Terület: " + surfaceArea);
        System.out.println("térfogat: " + volume);

        scanner.close();
    }
}