import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/22..
 */
public class TheWordsYiLike {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (firstCondition(line)&&secondCondition(line)&&thirdCondition(line)){
            System.out.println("Likes");
        }else {
            System.out.println("Dislikes");
        }

    }
    /**
     * 判断是否符合第一个条件
     * */
    private static boolean firstCondition(String line){
        // 匹配大写字母
        return line.matches("[A-Z]+");
    }
    /**
     * 判断是否符合第二个条件
     * */
    private static boolean secondCondition(String line){
        // match是从起始位置检查，不像find或者findall那种，可以在中间
        // 所以前后都要加上.*
        //检查有没有两个连续的字符， 第一个获取任意字符，第二个是和前面.相同的字母，类似于SQL预处理中的 ?
        return !line.matches(".*(.)(\\1).*");
    }
    /**
     * 判断是否符合第三个条件
     * */
    private static boolean thirdCondition(String line){
        // 判断是否会有子串重复（xyxy类型）
        return !line.matches(".*(.).*(.)(.*\\1)(.*\\2).*");
    }
}
