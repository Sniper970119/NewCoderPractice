import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/25.
 */
public class ComputeSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Varible> arrayList = new ArrayList<>();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            inputStringHandle(arrayList, scanner.nextLine());

        }
        for (int i = 0; i < m; i++) {
            int result = outputStringHandle(arrayList, scanner.nextLine());
            if (result == -1) {
                System.out.println("cannot_answer");
            } else {
                System.out.println(result);
            }
        }
    }

    /**
     * 处理输出字符串，在列表中寻找两个变量中影响变量相同的对象，如果没有返回-1（偶数加减不可能等于-1）
     * @param arrayList  保存信息的列表
     * @param mess      需要处理的字符串
     */
    private static int outputStringHandle(ArrayList<Varible> arrayList, String mess) {
        // 正则拿两个变量
        String[] tempA = mess.split("\\s-\\s");
        for (int i = 0; i < arrayList.size(); i++) {
            // 首先找到名字和第一个变量相同的元素
            if (arrayList.get(i).getName().equals(tempA[0])) {
                Varible varibleI = arrayList.get(i);
                for (int j = i + 1; j < arrayList.size(); j++) {
                    // 找到名字和第二个变量相同的元素
                    if (arrayList.get(j).getName().equals(tempA[1])) {
                        Varible varibleJ = arrayList.get(j);
                        // 对比这两个对象影响变量是否相同，相同输出系数差
                        if (varibleI.getInflluenceVarible().equals(varibleJ.getInflluenceVarible())) {
                            return varibleI.getFactor() - varibleJ.getFactor();
                        }
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 处理输入字符串，并将相关信息保存到列表中
     * @param arrayList  保存信息的列表
     * @param mess      需要处理的字符串
     */
    private static void inputStringHandle(ArrayList<Varible> arrayList, String mess) {
        String[] tempA = mess.split("\\s=\\s");
        String[] tempB = tempA[1].split("\\s-\\s");
        arrayList.add(new Varible(tempA[0], tempB[1], Integer.parseInt(tempB[0])));
        arrayList.add(new Varible(tempB[1], tempA[0], Integer.parseInt(tempB[0])));
    }
}

class Varible {
    private String name;
    private String inflluenceVarible;
    private int factor;

    Varible(String name, String inflluenceVarible, int factor) {
        this.factor = factor;
        this.inflluenceVarible = inflluenceVarible;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getFactor() {
        return factor;
    }

    public String getInflluenceVarible() {
        return inflluenceVarible;
    }

    @Override
    public String toString() {
        return "Varible{" +
                "name='" + name + '\'' +
                ", inflluenceVarible='" + inflluenceVarible + '\'' +
                ", factor=" + factor +
                '}';
    }
}
/*
3 2
a = 0 - b
b = -2 - c
c = 4 - d
b - d
b - c
* */
