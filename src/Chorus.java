import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/14.
 */
public class Chorus {
    // 动态规划的优化算法
    public static void main(String[] args) {
//        test();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Long[] arr = new Long[n];
        Long[] premax = new Long[n];
        Long[] max = new Long[n];
        Long[] premin = new Long[n];
        Long[] min = new Long[n];
        //获取学生能力值
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        scanner.nextLine();
        // 分别获取人数和间隔
        int k = scanner.nextInt();
        int d = scanner.nextInt();
        // 初始化第一排
        for (int i = 0; i < n; i++) {
            premax[i] = arr[i];
            premin[i] = arr[i];
            max[i] = arr[i];
            min[i] = arr[i];
        }
        //遍历，第一层是选中人数（因为初始化过，所以-1）
        for (int i = 0; i < k - 1; i++) {
            // 第二层是总人数
            for (int j = 0; j < n; j++) {
                Long minTemp = Long.MAX_VALUE;
                Long maxTemp = Long.MIN_VALUE;
                // 向前查找间隔个人，同时保证不小于0，防止越界。
                for (int l = Math.max(0, j - d); l < j; l++) {
                    // 判断更新最大值数组
                    if (maxTemp < Math.max(premax[l] * arr[j], premin[l] * arr[j])){
                        max[j] = Math.max(premax[l] * arr[j], premin[l] * arr[j]);
                        maxTemp = max[j];
                    }
                    // 判断更新最小值数组
                    if (minTemp > Math.min(premax[l] * arr[j], premin[l] * arr[j])){
                        min[j] = Math.min(premax[l] * arr[j], premin[l] * arr[j]);
                        minTemp = min[j];
                    }
                }
            }
            // 更新当前行为前一行，这层优化降低了算法的空间复杂度，使空间复杂度从O(n^2)降为O(2n)
            for (int j = 0; j < n; j++) {
                premax[j] = max[j];
                premin[j] = min[j];
            }
        }
        // 遍历查找最大值
        Long maxValue = 0l;
        for (int i = 0; i < n; i++) {
            if (maxValue < premax[i]){
                maxValue = premax[i];
            }
        }
        System.out.println(maxValue);
    }

    // 动态规划算法
    private static void test() {
        //获取学生个数
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n + 1];
        //获取能力值
        for(int i = 1;i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        //获取k值
        int k = scanner.nextInt();
        //获取d值
        int d = scanner.nextInt();
        //创建最大值和最小值两个辅助数组，long数组存放数值，范围更大
        long[][] f = new long[n + 1][k + 1];
        long[][] g = new long[n + 1][k + 1];
        //初始化两个数组，即K=1的情况
        for(int i = 1; i <= n; i++) {
            f[i][1] = arr[i];
            g[i][1] = arr[i];
        }
        //从k = 2开始填充（遍历每一行）
        for(int curK = 2; curK <= k; curK++) {
            for(int curN = curK; curN <= n; curN++) {  //遍历每一列
                long tempMax = Long.MIN_VALUE;         //临时最大、最小值变量
                long tempMin = Long.MAX_VALUE;
                //根据left的两个边界条件进行遍历
                //0 和curN -d 是两个边界，left变成负数
                for(int left = Math.max(1, curN - d); left <= curN - 1; left++){
                    //根据所得的递推公式更新最小值 最大值
                    if(tempMax < Math.max(f[left][curK - 1] * arr[curN], g[left][curK - 1] * arr[curN])) {
                        tempMax = Math.max(f[left][curK - 1] * arr[curN], g[left][curK - 1] * arr[curN]);
                    }

                    if(tempMin > Math.min(f[left][curK - 1] * arr[curN], g[left][curK - 1] * arr[curN])) {
                        tempMin = Math.min(f[left][curK - 1] * arr[curN], g[left][curK - 1] * arr[curN]);
                    }
                }
                //更新最大值
                f[curN][curK] = tempMax;
                //更新最小值
                g[curN][curK] = tempMin;
            }
        }
        //确定了K值，要得到最大值，则遍历第K列，即搜索f[curN~n][K]  （curN >= k）
        long maxResult = Long.MIN_VALUE;
        for(int curN = k; curN <= n; curN++) {
            if(f[curN][k] > maxResult)
                maxResult = f[curN][k];
        }
        System.out.println(maxResult);
    }
}
