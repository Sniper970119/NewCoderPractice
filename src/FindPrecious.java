import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/18.
 */
public class FindPrecious {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String t = scanner.nextLine();
        String s = scanner.nextLine();
        int length = s.length();
        int flag = 0;
        if (findSub(t,s)){
            System.out.println("Yes");
        }else
        System.out.println("No");
    }
    /**
     * 递归寻找子字符串是否匹配
     * */
    private static boolean findSub(String a,String b){
        // 判断两个字符串是否为空，为空则返回true或者false
        if (b.length()==0){
            return true;
        }
        if (a.length()==0){
            return false;
        }
        // 判断字符串中是否含有目标字符串中字符串，如果有，裁剪字符串递归调用
        for (int i = 0; i < a.length(); i++)
        {
           if ( b.charAt(0) == a.charAt(i)){
               if (findSub(a.substring(i+1),b.substring(1))){
                   return true;
               }
               return false;
           }

        }
        return false;
    }
}
