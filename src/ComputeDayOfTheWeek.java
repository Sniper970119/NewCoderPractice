import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/24.
 */
public class ComputeDayOfTheWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 获取用户输入的年月日
        int year = scanner.nextInt();
        int mouth = scanner.nextInt();
        int day = scanner.nextInt();
        String[] week = new String[]{"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        // 初始化一个LocalDate，用来输出星期几来验证算法
        LocalDate localDate = LocalDate.of(year, mouth, day);
        // 用来保存几个和末日日期相同的日期
        ArrayList<MyDate> staticDate = new ArrayList<>();
        // 首先初始化和末日永远相同的几个日期
        staticDate.add(new MyDate(4, 4));
        staticDate.add(new MyDate(6, 6));
        staticDate.add(new MyDate(8, 8));
        staticDate.add(new MyDate(10, 10));
        staticDate.add(new MyDate(12, 12));
        staticDate.add(new MyDate(9, 5));
        staticDate.add(new MyDate(5, 9));
        staticDate.add(new MyDate(7, 11));
        staticDate.add(new MyDate(11, 7));
        staticDate.add(new MyDate(3, 7));
        // 计算从1900年到用户输入年末日星期一共需要增加多少天
        int countOfYear = 0;
        for (int i = 1901; i <= year; i++) {
            // 根据末日算法，如果该年是平年，末日星期+1，如果该年是闰年，末日日期+2
            countOfYear++;
            if ((i % 4 == 0 && i % 400 != 0) || i % 400 == 0) {
                countOfYear++;
            }
        }
        // 初始化1900年末日星期为3
        int dayOfWeekIn1900 = 3;
        // 计算当前年份末日的星期
        int dayOfWeekInput = (dayOfWeekIn1900 + countOfYear) % 7;

        // 根据当前年的平年闰年去调用不同的方法
        int lengthDis = 0;
        if ((year % 4 == 0 && year % 400 != 0) || year % 400 == 0) {
            lengthDis = computeDis(staticDate, mouth, day, true);
        } else {
            lengthDis = computeDis(staticDate, mouth, day, false);
        }

        //对返回的末日距离进行判断，负数需要进行简单处理，加回正常范围
        int length = 0;
        length = (dayOfWeekInput + lengthDis) % 7;
        if (length < 0) {
            length = length + 7;
        }


        // 输出结果
        System.out.println("末日星期:" + week[dayOfWeekInput]);
        System.out.println("末日距离:" + lengthDis);
        System.out.println("预期结果：" + localDate.getDayOfWeek());
        System.out.println("实际结果：" + week[length]);


    }

    /**
     * 计算输入天数和最近的staticDate之间的天数差距
     *
     * @param staticDate 静态日期表
     * @param mouth      需要被计算的月份
     * @param day        需要被计算的日
     * @param flag       改年是否是闰年，如果是为true
     */
    private static int computeDis(ArrayList<MyDate> staticDate, int mouth, int day, boolean flag) {
        int length = 0;
        // 首先检查一二月份，因为在静态日期表中，没有这两个月份，这两个月份也需要被单独运算
        // 对一月份进行计算，对应平闰年分别是25号和24号和末日星期相同
        if (mouth == 1) {
            if (flag) {
                length = day - 25;
            } else {
                length = day - 24;
            }
        }
        // 对于二月份进行计算，同时区分平闰年
        if (mouth == 2) {
            if (flag) {
                length = day - 29;
            } else {
                length = day - 28;
            }
        }
        // 首先检查已经有的月份
        for (MyDate d : staticDate) {
            if (d.getMouth() == mouth) {
                length = day - d.getDay();
            }
        }
        return length;
    }


}

/**
 * 自定义日期类，不使用LocalDate，因为该类中可以直接返回星期几
 */
class MyDate {
    private int mouth;
    private int day;

    MyDate(int mouth, int day) {
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
