import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/24.
 */
public class TwoKindOfSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] data = new String[n + 1];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextLine();
        }
        boolean dictionary = true;
        boolean length = true;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (length && !judgeLength(data[i], data[j])) {
                    length = false;
                }
                if (dictionary && !judgeDictionary(data[i], data[j])) {
                    dictionary = false;
                }
            }
        }
        if (dictionary&&length){
            System.out.println("both");
        }else if (dictionary){
            System.out.println("lexicographically");
        }else if (length){
            System.out.println("lengths");
        }else {
            System.out.println("none");
        }

    }

    /**
     * 比较两个字符串的长度
     *
     * @param a 第一个字符串
     * @param b 第二个字符串
     * @return 返回返回结果，如果a<b 返回 true
     */
    private static boolean judgeLength(String a, String b) {
        if (a.length() < b.length()) {
            return true;
        }
        return false;
    }


    /**
     * 比较两个字符串的字典序
     *
     * @param a 第一个字符串
     * @param b 第二个字符串
     * @return 返回返回结果，如果a<b 返回 true
     */
    private static boolean judgeDictionary(String a, String b) {
        if (a.compareTo(b) < 0) {
            return true;
        }
        return false;
    }
}
