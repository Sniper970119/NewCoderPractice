import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/25.
 */
public class CoinWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String[] data = new String[n];
            scanner.nextLine();
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                data[j] = scanner.nextLine();
            }
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (!flag) {
                        if (compute(data[j], data[k])) {
                            flag = true;
                        }
                    }
                }
            }
            if (flag) {
                System.out.println("Yeah");
            } else {
                System.out.println("Sad");
            }


        }
    }

    private static boolean compute(String s, String s1) {
        // 定义是双生词标记
        boolean flagClock = true;
        boolean flagAntiClock = true;

        // 寻找s1 首字母在s的索引
        int begin = s1.indexOf(s.charAt(0));
        // 首先判断两个字符串长度是否相同，如果不相同直接输出结果
        if (s.length() != s1.length() || begin == -1) {
            return false;
        }
        // 查找
        for (int j = 1; j < s.length(); j++) {
            int clock = (begin + j) % s.length();
            int antiClock = (begin - j) % s.length();
            // 对逆时针查找索引进行处理，防止负数越界
            if (antiClock < 0) {
                antiClock = antiClock + s.length();
            }
            // 正序查找（顺时针）
            if (!(s.charAt(j) == s1.charAt(clock))) {
                flagClock = false;
            }
            // 逆序查找（逆时针）
            if (!(s.charAt(j) == s1.charAt(antiClock))) {
                flagAntiClock = false;
            }
        }
        if (flagClock || flagAntiClock) {
            return true;
        } else {
            return false;
        }

    }
}
/*
3
2
helloworld
hdlrowolle
2
helloworld
worldhello
2
abcde
acbde

* */