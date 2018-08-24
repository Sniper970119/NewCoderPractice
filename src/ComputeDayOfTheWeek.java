import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/24.
 */
public class ComputeDayOfTheWeek {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // 获取用户输入的年月日
        int year = scanner.nextInt();
        int mouth = scanner.nextInt();
        int day = scanner.nextInt();
        // 初始化一个LocalDate，用来输出星期几来验证算法
        LocalDate localDate = LocalDate.of(year,mouth,day);
        // 用来保存几个和末日日期相同的日期
        ArrayList<MyDate> staticDate = new ArrayList<>();
        // 首先初始化和末日永远相同的几个日期
        staticDate.add(new MyDate(4,4));
        staticDate.add(new MyDate(6,6));
        staticDate.add(new MyDate(8,8));
        staticDate.add(new MyDate(10,10));
        staticDate.add(new MyDate(12,12));
        staticDate.add(new MyDate(9,5));
        staticDate.add(new MyDate(5,9));
        staticDate.add(new MyDate(7,11));
        staticDate.add(new MyDate(11,7));
        staticDate.add(new MyDate(3,7));
        // 计算从1900年到用户输入年末日星期一共需要增加多少天
        int countOfYear = 0;
        for (int i = 1901; i <= year; i++) {
            // 根据末日算法，如果该年是平年，末日星期+1，如果该年是闰年，末日日期+2
            countOfYear++;
            if ((i%4==0&&i%400!=0)||i%400==0){
                System.out.println(i+"   run");
                countOfYear++;
            }
        }
        // 初始化1900年末日星期为3
        int dayOfWeekIn1900 = 3;
        // 计算当前年份末日的星期
        int dayOfWeekInput = (dayOfWeekIn1900+countOfYear) % 7;

        System.out.println(localDate.getDayOfWeek());
//        System.out.println(countOfYear);
        System.out.println(dayOfWeekInput);

    }


}

/**
 * 自定义日期类，不使用LocalDate，因为该类中可以直接返回星期几
 * */
class MyDate{
    private int mouth;
    private int day;
    MyDate(int mouth, int day){
        this.mouth = mouth;
        this.day = day;
    }

    public int getMouth() {
        return mouth;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
