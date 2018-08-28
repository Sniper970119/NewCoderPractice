import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/28.
 */
public class RelationBetweenAddAndOr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int flag = 0;
            for (int j = 1; j < Integer.MAX_VALUE; j++) {
                int temp = x | j;
                if (x + j == temp) {
                    System.out.println(j);
                    y--;
                    flag = j;
                    if (y<=0){
                        break;
                    }
//                    System.out.println(j);
                }
            }
            System.out.println(flag);
//            int temp = 1;
//            while (y != 0) {
//                int result = x | temp;
//                System.out.println("result:" + result+" "+temp);
//                if (x + temp == result) {
//                    y--;
//                    System.out.println("is");
//                }
//                temp++;
//            }
//            System.out.println(temp);
        }
    }

}
