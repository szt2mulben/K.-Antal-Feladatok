import java.util.Scanner;

public class ConditionalVariableMutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter an integer for 'a': ");
        int a = scanner.nextInt();

        System.out.print("Please enter an integer between 0 and 30 for 'b': ");
        int b = scanner.nextInt();

        System.out.print("Please enter an integer between 0 and 100 for 'credits': ");
        int credits = scanner.nextInt();

        System.out.print("Please enter a boolean (true/false) for 'isBonus': ");
        boolean isBonus = scanner.nextBoolean();

        System.out.print("Please enter an integer between 0 and 50 for 'd': ");
        int d = scanner.nextInt();

        System.out.print("Please enter an integer between 0 and 500 for 'time': ");
        int time = scanner.nextInt();

        int output1 = 0;
        String output2 = "";
        int output3 = 0;
        String output4 = "";

        if (a % 2 == 0) {
            output1++;
        }

        if (b >= 10 && b <= 20) {
            output2 = "Sweet!";
        } else if (b < 10) {
            output2 = "Less!";
        } else {
            output2 = "More!";
        }

        if (credits >= 50 && !isBonus) {
            output3 -= 2;
        } else if (credits < 50 && !isBonus) {
            output3--;
        }

        if (d % 4 == 0 && time <= 200) {
            output4 = "Check";
        } else if (time > 200) {
            output4 = "Time out";
        } else {
            output4 = "Run Forest Run!";
        }
        System.out.println("Output1: " + output1);
        System.out.println("Output2: " + output2);
        System.out.println("Output3: " + output3);
        System.out.println("Output4: " + output4);

        scanner.close();
    }
}