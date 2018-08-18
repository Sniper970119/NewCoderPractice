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
    private static boolean findSub(String a,String b){
//        System.out.println("string:"+a+" "+b);
        if (b.length()==0){
            return true;
        }
        if (a.length()==0){
            return false;
        }
        for (int i = 0; i < a.length(); i++)
        {
           if ( b.charAt(0) == a.charAt(i)){
//               System.out.println(b.charAt(0)+" "+a.charAt(i));
               if (findSub(a.substring(i+1),b.substring(1))){
                   return true;
               }
               return false;
           }

        }
        return false;
    }
}
