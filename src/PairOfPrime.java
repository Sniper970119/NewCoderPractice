import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/22.
 */
public class PairOfPrime {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = scanner.nextInt();
        // 初始化质数列表
        for (int i = 2; i < n; i++) {
            if (judgePrime(i)){
                arrayList.add(i);
            }
        }
        int result = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i; j < arrayList.size(); j++) {
                if (arrayList.get(i)+arrayList.get(j)==n){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    private static boolean judgePrime(int n){
        if (n==1){
            return true;
        }
        for (int i = 2; i < n; i++) {
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
}
