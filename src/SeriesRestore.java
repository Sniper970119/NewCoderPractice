import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/18.
 */
public class SeriesRestore {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] data = new int[n+1];
        int[] book = new int[11];
        for (int i = 0; i < n; i++)
        {
            data[i] = scanner.nextInt();
            book[data[i]] = 1;
        }


    }
}
