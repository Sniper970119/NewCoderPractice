import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/24.
 */
public class MakeQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            compute(scanner.nextInt());
        }
    }

    /**
     * 计算输出为1~n的原队列
     *
     * @param n 1~n 的n
     */
    private static void compute(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        // 队列操作，是考拉操作的逆操作
        for (int i = n - 1; i > 0; i--) {
            int temp = queue.poll();
            queue.add(temp);
            queue.add(i);
        }
        // 将最后一个元素出栈再入栈，同样是逆操作所需
        int temp = queue.poll();
        queue.add(temp);
        // 将队列转存数组，以便逆序输出
        int[] data = new int[n + 1];
        for (int i = n-1; i >= 0; i--) {
            data[i] = queue.poll();
        }
        // 输出数组，同时保证最后一位输出格式
        for (int i = 0; i < n - 1; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println(data[n-1]);
    }
}
