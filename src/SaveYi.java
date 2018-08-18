import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/18.
 */
public class SaveYi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n + 1];
        int[] y = new int[n + 1];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y[i] = scanner.nextInt();
        }
        int flag = 0;
        double min = Integer.MAX_VALUE;
        // 计算离起点最近的点，不过为什么不可以用欧几里德度量？
        for (int i = 0; i < n; i++) {
            double temp = x[i] + y[i];
            if (min >= temp) {
                min = temp;
                flag = i;
            }
        }
        // 输出结果
        int result = (x[flag] - 1) + (y[flag] - 1);
        System.out.println(result);
    }
}
