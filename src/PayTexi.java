import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Sniper on 2018/4/9.
 */
public class PayTexi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = scanner.nextInt();
        }
        Arrays.sort(money);
        for (int i = 0; i < n; i++) {
            System.out.print(money[i] + " ");
        }
        System.out.println();
        int sum = 0;
        int result = 0;
        int from = n - 1;
        int to = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (sum < m) {
                sum += money[i];
                result++;
                from--;
            }
        }

        while (true) {
            if (sum - money[to] + money[from - 1] >= m) {
                from--;
                to--;
            } else {
                break;
            }
        }

        for (int i = from; i < to; i++) {
            System.out.print(money[i] + " ");
        }
        System.out.println();

        for (int i = to; i >= from; i--) {
            for (int j = to - 1; j >= 0; j--) {
                for (int k = 0; k < j; k++) {
                    if (money[k] + money[j] >= money[i]) {
                        result++;
                        money[k] = 0;
                        money[j] = 0;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
