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
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!flag[i]){
                arrayList.add(i);
            }
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        computeString(list,arrayList,0);
//        for (ArrayList<Integer> i:list) {
//            System.out.println(i.get(0));
//        }

        // 使用全排列计算完整数组
        int[] temp;
        ArrayList<Integer> tempArray;
        int index;
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            temp = Arrays.copyOf(a,n);
            tempArray = list.get(i);
//            System.out.println(tempArray);
            index = 0;
            // 填充数组，使数组全为非0数
            for (int j = 0; j < n; j++) {
                if (temp[j] == 0) {
                    temp[j] = tempArray.get(index);
                    index++;
                }
            }
//            for (int zz = 0; zz < a.length; zz++) {
//                System.out.print(a[zz]+" ");
//            }
            System.out.println();
            if (judgeOrder(temp,k)){
                result++;
            }
        }
        System.out.println(result);
    }
    private static boolean judgeOrder(int[] data, int n){
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j < data.length; j++) {
                if (data[i]<data[j]){
                System.out.println(data[i]+" "+data[j]);
                    result++;
                }
            }

        }
        if (result==n){
            System.out.println("true");
            return true;
        }else {
            System.out.println("false");
            return false;
        }

    }
    private static void computeString (List<ArrayList<Integer>> list, ArrayList<Integer> arrayList, int n){
        if (n==arrayList.size()) {
//            System.out.println(arrayList);
            list.add(new ArrayList<>(arrayList));
        }else {
            for (int i = 0; i < arrayList.size(); i++) {
//                System.out.println("1:"+arrayList+" n: "+n);
                Collections.swap(arrayList,i,n);
//                System.out.println(arrayList);
                computeString(list, arrayList, n + 1);
                Collections.swap(arrayList,n,i);
            }
        }
    }
}
