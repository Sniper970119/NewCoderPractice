import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/28.
 */
public class MaxAddSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            arrayList.add(scanner.nextInt());
        }
        int length = arrayList.size();
        int max = 0;
        DynamicPoint[] points;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            points = new DynamicPoint[length+1];
            int sumTemp = 0;
            int flag = arrayList.get(i);
//            DynamicPoint temp = new DynamicPoint(flag);
//            points[i] = temp;
            for (int j = 0; j < length; j++) {
                points[j] = new DynamicPoint(arrayList.get(j));
//                System.out.println("new:"+points[j]);
            }
            for (int j = i + 1; j < length; j++) {
                if (arrayList.get(j)>arrayList.get(i)){
                    for (int k = i; k < j; k++) {
                        // 判断动态点是否符合条件
                        if (points[k].getValue()<arrayList.get(j)){
                            sumTemp = points[k].getMax()+arrayList.get(j);
                            // 判断是否需要更新动态点
                            if (points[j].getMax()<sumTemp){
                                points[j].setMax(sumTemp);
                                points[j].setValue(arrayList.get(j));
                            }
                        }
                    }
                }
            }
            // 遍历查找最大值
            for (int j = 0; j < length; j++) {
//                System.out.println(points[j]+" ");
                if (max<points[j].getMax()){
                    max = points[j].getMax();
                }
            }
//            System.out.println();
        }
        System.out.println(max);
    }
}
class DynamicPoint{
    private int max;
    private int value;

    DynamicPoint(int value){
        this.value =value;
        this.max = value;
    }

    @Override
    public String toString() {
        return "dynamicPoint{" +
                "max=" + max +
                ", value=" + value +
                '}';
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
// 5 1 3 4 9 7 6 8