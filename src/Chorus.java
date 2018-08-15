import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/14.
 */
public class Chorus {
    // 使用动态规划
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
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        scanner.nextLine();
        int k = scanner.nextInt();
        int d = scanner.nextInt();
        // 初始化第一排
        for (int i = 0; i < n; i++) {
            premax[i] = arr[i];
            premin[i] = arr[i];
            max[i] = arr[i];
            min[i] = arr[i];
        }
        for (int i = 0; i < k - 1; i++) {
            for (int j = 0; j < n; j++) {
                Long minTemp = Long.MAX_VALUE;
                Long maxTemp = Long.MIN_VALUE;
                for (int l = Math.max(0, j - d); l < j; l++) {
                    if (maxTemp < Math.max(premax[l] * arr[j], premin[l] * arr[j])){
                        max[j] = Math.max(premax[l] * arr[j], premin[l] * arr[j]);
                        maxTemp = max[j];
                    }
                    if (minTemp > Math.min(premax[l] * arr[j], premin[l] * arr[j])){
                        min[j] = Math.min(premax[l] * arr[j], premin[l] * arr[j]);
                        minTemp = min[j];
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                premax[j] = max[j];
                premin[j] = min[j];
            }
        }
        Long maxValue = 0l;
        for (int i = 0; i < n; i++) {
            if (maxValue < premax[i]){
                maxValue = premax[i];
            }
        }
        System.out.println(maxValue);
    }

    // 备忘录算法
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
//            System.out.println(f[curN][k]);
            if(f[curN][k] > maxResult)
                maxResult = f[curN][k];
        }
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                System.out.print(f[i][j]+" ");
//                System.out.print ("   ");
//                System.out.print(g[i][j]+" ");
            }
            System.out.println(" ");
        }

        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
//                System.out.print(f[i][j]+" ");
//                System.out.print ("   ");
                System.out.print(g[i][j]+" ");
            }
            System.out.println(" ");
        }
        System.out.println(maxResult);
    }
}


// [7, 7, 217, 1519, 660, 1715, 2156, 2068, 1081, 735, 517, 490, 987, 490, 611, 7, 940, 1692, 1078, 611, 1833, 1833, 1457, 611, 1269, 2021, 282, 1960, 245, 2209, 1715, 376, 1176, 1457, 1128, 47]
//47


/*
36
7 -15 31 49 -44 35 44 -47 -23 15 -11 10 -21 10 -13 0 -20 -36 22 -13 -39 -39 -31 -13 -27 -43 -6 40 5 -47 35 -8 24 -31 -24 -1
3 31

-3255
10633
32340
53165
75460
101332
52969
32340
25333
21560
48363
21560
29939
0
46060
82908
47432
29939
89817
89817
71393
29939
62181
99029
13818
86240
10780
108241
77315
18424
53016
71393
55272
2303


 3
 7 4 7
 2 50
  */