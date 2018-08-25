import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/25.
 */
public class AirQuality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] data = new int[n + 1];
        int[] dataAll = new int[k * n + 1];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
            for (int j = 0; j < k; j++) {
                dataAll[j * n + i] = data[i];
            }
        }
        int max = 0;
        for (int i = 0; i < n * k; i++) {
            int maxTemp = 1;
            int index = dataAll[i];
//            System.out.println("dataAll:"+index);
            for (int j = i + 1; j < n * k; j++) {
                if (index <= dataAll[j]) {
//                    System.out.println(index + " " + dataAll[j]);
                    index = dataAll[j];
                    maxTemp++;
                }
            }
//            System.out.println("maxTemp:"+maxTemp);
            if (max < maxTemp) {
                max = maxTemp;
            }
        }
        System.out.println(max);
//        for (int i = 0; i < n * k; i++) {
//            System.out.print(dataAll[i] + " ");
//        }

    }
}
