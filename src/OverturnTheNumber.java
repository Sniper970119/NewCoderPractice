import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/22.
 */
public class OverturnTheNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int result = overturn(overturn(m)+overturn(n));
        System.out.println(result);

    }

    /**
     * 计算数字的翻转
     * @param number : 需要被翻转的数字
     * @return :翻转之后的数字，返回int类型。
     * */
    private static int overturn(int number){
        String words = ""+number;
        String tempOne = "";
        for (int i = words.length()-1; i >=0; i--) {
            tempOne = tempOne + words.charAt(i);
        }
        try {
            return Integer.parseInt(tempOne);
        }catch (NumberFormatException e){
            System.out.println("Error");
            System.exit(0);
        }
        return 0;
    }
}
