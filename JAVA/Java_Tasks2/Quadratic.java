import java.util.Scanner;

public class Quadratic {
    public static void Quadratic1(int a, int b, int c) {
        if (a == 0) {
            System.out.println("Az 'a' értéke nem lehet nulla!");
            return;
        }

        int seged = b * b - 4 * a * c;

        if (seged > 0) {
            double seged1 = (-b + Math.sqrt(seged)) / (2.0 * a);
            double seged2 = (-b - Math.sqrt(seged)) / (2.0 * a);
            System.out.println("Két valós gyök: x1 = " + seged1 + ", x2 = " + seged2);
        } else if (seged == 0) {
            double root = -b / (2.0 * a);
            System.out.println("Egy valós gyök: x = " + root);
        } else {
            System.out.println("Nincs valós gyök.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kérem adja meg az 'a' értékét: ");
        int a = scanner.nextInt();

        System.out.print("Kérem adja meg az 'b' értékét: ");
        int b = scanner.nextInt();

        System.out.print("Kérem adja meg az 'c' értékét: ");
        int c = scanner.nextInt();

        scanner.close();

        Quadratic1(a, b, c);
    }
}