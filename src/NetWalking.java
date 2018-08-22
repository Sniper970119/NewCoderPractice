import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/22.
 */
public class NetWalking {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int result = step(m,n);
        System.out.println(result);
    }
    /**
     * 计算步数，递归调用
     * */
    private static int step(int m,int n){
        if(m==0||n==0){
            return 1;
        }
        return step(m - 1,n)+ step(m,n - 1);
    }
}
