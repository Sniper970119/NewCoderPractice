import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/18.
 */
public class Fibonacci {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] fibonacci = new int[n];
        if (n==0||n==1){
            System.out.println(0);
            System.exit(0);
        }
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        int flag = 0;
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
            if (fibonacci[i]>=n){
                flag = i;
                break;
            }
        }
        int result = Math.min(Math.abs(fibonacci[flag]-n),Math.abs(fibonacci[flag-1]-n));
        System.out.println(result);
    }
}
