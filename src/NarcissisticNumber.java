import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/14.
 */
public class NarcissisticNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            ArrayList<Integer> list = new ArrayList<>();
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            for (int i = m; i <n; i++) {
                int unit = i%10;
                int decade = i/10%10;
                int hundred = i/100;
                if(unit*unit*unit+decade*decade*decade+hundred*hundred*hundred ==i){
                    list.add(i);
                }
            }
            if(list.size() ==0){
                System.out.println("no");
                continue;
            }
            for (int i = 0; i < list.size() -1; i++) {
                System.out.print(list.get(i)+" ");
            }
            System.out.println(list.get(list.size()-1));
        }
    }
}
