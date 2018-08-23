import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Sniper on 2018/8/23.
 */
public class RestoreArray {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        boolean[] flag = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if(a[i] != 0){
                flag[a[i]] = true;
            }
        }
        // 把没有使用过的数字放到列表中，供后面全排列用
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!flag[i]){
                arrayList.add(i);
            }
        }
        // list用来保存arraylist 变量，保存列表的列表，保存全排列的结果
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        computeString(list,arrayList,0);

        // 使用全排列计算完整数组 eg[4 1 3 2 5]
        int[] temp;
        ArrayList<Integer> tempArray;
        int index;
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            temp = Arrays.copyOf(a,n);
            tempArray = list.get(i);
            index = 0;
            // 填充数组，使数组全为非0数
            for (int j = 0; j < n; j++) {
                if (temp[j] == 0) {
                    temp[j] = tempArray.get(index);
                    index++;
                }
            }
            // 如果满足k组排列
            if (judgeOrder(temp,k)){
                result++;
            }
        }
        System.out.println(result);
    }
    /**
     * 判断排序是否正确，即是否有需要组排列
     * @param data 需要被判断的数组
     * @param n 判断条件，需要有n组排列
     * @return 是否符合要求，符合返回true
     * */
    private static boolean judgeOrder(int[] data, int n){
        int result = 0;
        // 判断排序组数
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j < data.length; j++) {
                if (data[i]<data[j]){
                    result++;
                }
            }

        }
        // 如果排列组数和需求组数一样，则返回true
        if (result==n){
            return true;
        }else {
            return false;
        }

    }
    /**
     * 计算数组的全排列
     * @param arrayList 需要被全排列的列表
     * @param list 保存全排列的列表
     * @param n 索引，用来控制从某一位开始交换
     * */
    private static void computeString (List<ArrayList<Integer>> list, ArrayList<Integer> arrayList, int n){
        //如果已经交换到了最后一位，即和长度相同
        if (n==arrayList.size()) {
            // 去重判断，防止重复计算
            if (!list.contains(arrayList)){
                list.add(new ArrayList<>(arrayList));
            }
        }else {
            // 遍历交换数据
            for (int i = 0; i < arrayList.size(); i++) {
                Collections.swap(arrayList,i,n);
                computeString(list, arrayList, n + 1);
                Collections.swap(arrayList,n,i);
            }
        }
    }
}
