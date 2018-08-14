import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/14.
 */
public class computeSum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            // 获取m和n的值
            double n = scanner.nextDouble();
            int m = scanner.nextInt();
            // 和
            double sum = 0;
            // 遍历求和
            for (int i = 1; i <= m; i++) {
                sum += n;
                n = Math.sqrt(n);
            }
            System.out.println(String.format("%.2f", sum));
        }

    }
}
