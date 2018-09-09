import java.util.Scanner;

/**
 * Created by Sniper on 2018/9/9.
 */
public class FindUnqualified {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[] z = new int[n];
        for (int i = 0; i < n; i++) {
           x[i] = scanner.nextInt();
           y[i] = scanner.nextInt();
           z[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(x[i]);
            System.out.print(y[i]);
            System.out.println(z[i]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (x[i] < x[j] && y[i] < y[j] && z[i] < z[j]) {
//                    System.out.println("one");
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
