import com.sun.org.apache.xpath.internal.SourceTree;

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
        int sum = 0;
        int result = 0;

        // 正序遍历
        for (int i = 0; i < n; i++) {
            sum += money[i];
            result++;
            if (sum>=m){
                break;
            }
        }
        int dis = sum -m;
        // 倒序遍历，检查能否去掉小额面值
        for (int i = result -1; i >= 0; i--) {
            if (dis>=money[i]){
                dis -= money[i];
                result--;
            }
        }
        System.out.println(result);
    }
}
