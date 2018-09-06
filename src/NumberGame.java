import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Sniper on 2018/9/6.
 */
public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n + 1];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        Arrays.sort(data);
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (data[i] > max + 1) {
                break;
            }
            max += data[i];
        }
        System.out.println(max + 1);
    }
}
