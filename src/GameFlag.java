import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/22.
 */
public class GameFlag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // zz
        if(a>1024||a<1||b>1024||b<1){
            System.out.println(-1);
        }else{
            if(a!=b)System.out.println(0);
            if(a==b)System.out.println(1);
        }
    }
}
