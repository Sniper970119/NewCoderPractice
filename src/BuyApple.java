import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/22.
 */
public class BuyApple {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 6和8不可能组合出奇数，所以如果是奇数直接不买
        if (n%2==1){
            System.out.println(-1);
            System.exit(0);
        }
        int remain = n % 24;
        // 24需要3个8来组成（最小情况）
        int result = n / 24 * 3;
        // 因为6和8的最小公倍数为24，在这以下只有6，8，12，14，16，18，20，22 这几种情况可以买
        if (remain==0||remain==6||remain==8||remain==12||remain==14||remain==16||remain==18||remain==20||remain==22){
            // 剩下的需要一袋
            if (remain==6||remain==8){
                result+=1;
            }
            // 剩下的须二袋
            if (remain==12||remain==14||remain==16){
                result+=2;
            }
            // 剩下的须三袋
            if (remain==18||remain==20||remain==22){
                result+=3;
            }
        }else {
            result = -1;
        }
        System.out.println(result);
    }
}
