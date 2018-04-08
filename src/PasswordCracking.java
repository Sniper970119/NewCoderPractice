import java.util.Scanner;

/**
 * Created by Sniper on 2018/4/8.
 */
public class PasswordCracking {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char[] lowLetter = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
                'o','p','q','r','s','t','u','v','w','x','y','z'};       //对小写字母打表
        char[] highLetter = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
                'O','P','Q','R','S','T','U','V','W','X','Y','Z'};       //对大写字母打表
        String data = scanner.nextLine();
        char[] dataByte = data.toCharArray();
        for (int i = 0; i < dataByte.length; i++) {     //遍历字符数组
            for (int j = 0; j < lowLetter.length; j++) {
                if (dataByte[i]==lowLetter[j]){
                    dataByte[i] = lowLetter[(j+1)%26];      //转换
                    break;
                }
            }
            for (int j = 0; j < highLetter.length; j++) {
                if (dataByte[i]==highLetter[j]){
                    dataByte[i] = highLetter[(j+1)%26];
                    break;
                }
            }
        }
//        System.out.print("res:");
        for (int j = 0; j < dataByte.length; j++) {
            System.out.print(dataByte[j]);
        }
    }
}
