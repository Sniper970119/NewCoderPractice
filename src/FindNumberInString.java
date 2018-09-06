import java.util.Scanner;

/**
 * Created by Sniper on 2018/9/6.
 */
public class FindNumberInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        // 正则分割，以非数字贪婪匹配
        String result[] = line.split("\\D+");
        int index = 0;
        int max = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i].length()>max){
                max = result[i].length();
                index = i;
            }
        }
        System.out.println(result[index]);
    }
}
