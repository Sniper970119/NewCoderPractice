import org.apache.derby.vti.IFastPath;

import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/22.
 */
public class StatisticsPalindrome {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String stringA = scanner.nextLine();
        String stringB = scanner.nextLine();
        int lengthA = stringA.length();
        int result = 0;
        for (int i = -1; i < lengthA; i++) {
            String a =computeString(stringA, stringB,i);
//            System.out.println(a);
            if (judgePalindrome(a)){
                result++;
            }
        }
        System.out.println(result);
    }


    /**
     * 检查是否为回文串
     * @param words:需要被检查的字符串
     * @return 检查结果
     * */
    private static boolean judgePalindrome(String words){
        int length = words.length()-1;
        for (int i = 0; i <=length-i ; i++) {
            if (words.charAt(i)!=words.charAt(length-i)){
                return false;
            }
        }
        return true;
    }
    /**
     * 字符串处理，将两个字符串处理成一个字符串并返回
     * @param stringA:主字符串，即被插入的字符串
     * @param stringB: 插入的字符串
     * @param index: 位置索引，将stringB插入到stringA的 index位置后
     * @return 处理后的字符串,如果index超出返回则返回null
     * */
    private static String computeString(String stringA, String stringB,int index){
        if (index>stringA.length()-1){
            System.out.println("Error");
            return null;
        }
        // 因为substring 是到 endindex -1 位置，所以这里 +1
        String stringATemp1 = stringA.substring(0,index+1);
        String stringATemp2 = stringA.substring(index+1);
        return stringATemp1+stringB+stringATemp2;
    }
}
