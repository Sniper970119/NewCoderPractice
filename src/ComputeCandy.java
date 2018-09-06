import java.util.Scanner;

/**
 * Created by Sniper on 2018/9/6.
 */
public class ComputeCandy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        int b;
        int c;
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();
        int number4 = scanner.nextInt();
        for (int i = -30; i <= 30; i++) {
            a = i;
            for (int j = -30; j <= 30; j++) {
                b = j;
                for (int k = -30; k <= 30; k++) {
                    c = k;
                    if (a - b == number1 && b - c == number2 && a + b == number3 && b + c == number4) {
                        System.out.println(a + " " + b + " " + c);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("No");
    }
}
