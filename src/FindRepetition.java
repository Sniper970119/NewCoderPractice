import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/22.
 */
public class FindRepetition {
    public static void main(String[] args){
        // 保存数据
        ArrayList<Integer> arrayList = new ArrayList<>();
        // set去重，保存都有哪些数字
        HashSet<Integer> data = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int all = 0;
        while (scanner.hasNextInt()){
            all++;
            int temp = scanner.nextInt();
            arrayList.add(temp);
            data.add(temp);
        }
        // 第一层对set遍历，找出都有哪些数字
        for (Integer integer:data) {
            int temp = 0;
            // 第二层对arraylist遍历，查找有多少个关键数字
            for (Integer i : arrayList) {
                if (i==integer){
                    temp++;
                }
            }
            // 如果大于半数，输出，程序退出
            if (temp>=(all/2)){
                System.out.println(integer);
                System.exit(0);
            }

        }

    }
}
