public class AVariableModifications {
    public static void main(String[] args) {
        int a = 3;
        a += 10;
        System.out.println("a after increasing by 10: " + a);

        int b = 100;
        b -= 7;
        System.out.println("b after decreasing by 7: " + b);

        int c = 44;
        c *= 2;
        System.out.println("c after doubling its value: " + c);

        int d = 125;
        d /= 5;
        System.out.println("d after dividing by 5: " + d);

        int e = 8;
        e = e * e * e; // Or e = (int) Math.pow(e, 3);
        System.out.println("e after cubing its value: " + e);

        int f1 = 123;
        int f2 = 345;
        boolean f1GreaterThanF2 = f1 > f2;
        System.out.println("f1 is greater than f2: " + f1GreaterThanF2);

        int g1 = 350;
        int g2 = 200;
        boolean doubleG2GreaterThanG1 = 2 * g2 > g1;
        System.out.println("Double the value of g2 is greater than g1: " + doubleG2GreaterThanG1);

        int h = 135798745;
        boolean has11AsDivisor = h % 11 == 0;
        System.out.println("h has 11 as a divisor: " + has11AsDivisor);

        int i1 = 10;
        int i2 = 3;
        boolean i1GreaterThanI2SquaredAndSmallerThanI2Cubed = i1 > i2 * i2 && i1 < i2 * i2 * i2;
        System.out.println("i1 is greater than i2 squared and smaller than i2 cubed: " + i1GreaterThanI2SquaredAndSmallerThanI2Cubed);

        int j = 1521;
        boolean divisibleBy3Or5 = j % 3 == 0 || j % 5 == 0;
        System.out.println("j is divisible by 3 or 5: " + divisibleBy3Or5);
    }
}