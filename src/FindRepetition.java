import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/22.
 */
public class FindRepetition {
    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> data = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int all = 0;
        while (scanner.hasNextInt()){
            all++;
            int temp = scanner.nextInt();
            arrayList.add(temp);
            data.add(temp);
        }
        for (Integer integer:data) {
            int temp = 0;
            for (Integer i : arrayList) {
                if (i==integer){
                    temp++;
                }
            }
            if (temp>=(all/2)){
                System.out.println(integer);
                System.exit(0);
            }

        }

    }
}
