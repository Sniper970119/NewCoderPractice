import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/22.
 */
public class SortIDCard {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String idLine = scanner.nextLine().trim();
            // 正则去掉身份证号中的空格
            idLine = idLine.replaceAll("\\s","");
            // 如果长度小于6 直接输出就行
            if (idLine.length()<=6){
                System.out.println(idLine);
            }
            // 如果在6~14位之间，寻找子串并在中间加上空格
            if (idLine.length()>6&&idLine.length()<=14){
                System.out.println(idLine.substring(0,6)+" "+idLine.substring(6));
            }
            // 同前
            if (idLine.length()>14){
                System.out.println(idLine.substring(0,6)+" "+idLine.substring(6,14)+" "+idLine.substring(14));
            }
        }
    }
}
