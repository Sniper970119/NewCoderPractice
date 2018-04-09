import java.util.Scanner;

/**
 * Created by Sniper on 2018/4/9.
 */
public class BeautifulNecklace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int min = 0;
        int need = 0;
        for (int i = 0; i < m; i++) {
            int temp = scanner.nextInt();
            min += temp;
            need += scanner.nextInt() - temp;
        }
        int left = n - min;
        int fenZi = 1;
        int fenMu = 1;
        for (int i = 1; i <= left; i++) {
            fenZi *= i;
        }
        while (left--!=0){
            fenMu *= need--;
        }

        System.out.println(fenMu/fenZi);

    }
}
