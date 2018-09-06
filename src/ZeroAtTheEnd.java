import java.util.Scanner;

/**
 * Created by Sniper on 2018/9/6.
 */
public class ZeroAtTheEnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(n / 5 + n / 25 + n / 125 + n / 625);
    }
}
