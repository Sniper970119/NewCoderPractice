import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Sniper on 2018/8/28.
 */
public class ComputeCombination {
    static String allIn = "0123456789";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] flag = new int[11];
        ArrayList<Integer> arrayList = new ArrayList<>();
        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            int temp = scanner.nextInt();
            if (temp == 0) {
                arrayList.add(i);
                int indexTemp = allIn.indexOf(i + "");
//                System.out.println(i+" "+allIn);
                String tempString = allIn.substring(0, indexTemp) + allIn.substring(indexTemp + 1);
//                System.out.println("first:"+tempString);
                treeSet.add(tempString);
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            compute(treeSet,arrayList);
        }
        Iterator<String> iterator2 = treeSet.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

    }
    private static void compute(TreeSet<String> treeSet, ArrayList<Integer> arrayList){
        ArrayList<String> arrayListString = new ArrayList<>();
        treeSet.add(allIn);
        Iterator<String> iterator = treeSet.iterator();
        // 遍历已经存在在集合中的字符串，重新计算子串，并添加到中间集合中（在迭代器中不能对结构增删）
        while (iterator.hasNext()) {
            String message = iterator.next();
            for (int i = 0; i < arrayList.size(); i++) {
                int indexTemp = message.indexOf(arrayList.get(i) + "");
                if (indexTemp != -1) {
//                    System.out.println("mes:"+message+" mess:"+message.substring(0, indexTemp)+" + "+ message.substring(indexTemp + 1));
                    String tempString = message.substring(0, indexTemp) + message.substring(indexTemp + 1);
                    arrayListString.add(tempString);
//                    System.out.println("second:"+message+" "+tempString);
                }
            }
        }
        // 从中间容器中存入最终容器
        for (int i = 0; i < arrayListString.size(); i++) {
            treeSet.add(arrayListString.get(i));
        }
    }
}
