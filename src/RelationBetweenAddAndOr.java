import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/28.
 */
public class RelationBetweenAddAndOr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            findNumber(x, y);
        }
    }

    private static void findNumber(int x, int k) {
        int y = 0, n = 1;
        while (k > 0) {
            if (x % 2 != 0) {
                //此时x的二进制最右端为1的话，一直使x右移，就是找到x的为0的位置
                while (x % 2 != 0) {
                    n = n * 2;  //每移一位，n记录一下变化的值
                    x = x / 2;
                }
            }
            //如果k的二进制最右端为1，就使y加上n
            if (k % 2 != 0) {
                y = y + n;
            }
            n = n * 2;
            x = x / 2;
            k = k / 2; //同时使x,k右移，以便下一步判断
        }
        System.out.println(y);
    }
}
