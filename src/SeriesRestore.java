import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/18.
 */
public class SeriesRestore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] data = new int[n + 1];
        int[] book = new int[101];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
            book[data[i]] = 1;
        }
        computeArray(data,book);

    }

    private static void computeArray(int[] data, int[] book) {
        int length = 0;
        int[] newData = new int[101];
        // 遍历计算未出现过的数字以及个数
        for (int i = 0; i < book.length; i++) {
            if (book[i] == 0) {
                newData[length] = i;
                length++;
            }
        }
        // 遍历计算data中0的个数，减少排列范围，降低时间复杂度
        int dataIsZeroLength = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i]==0){
                dataIsZeroLength++;
            }
        }
    }
}


