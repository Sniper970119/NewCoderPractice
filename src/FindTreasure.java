import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Sniper on 2018/4/8.
 */

public class FindTreasure {
    // 主函数，没有进行拆分，都放在一个函数中进行
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(in.nextInt(), in.nextInt(), in.nextInt());
        }
        int a[] = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            a[j] = j;
        }
        Arrays.sort(edges, new Comparator<Edge>() {     //复写比较方法
            @Override
            public int compare(Edge o1, Edge o2) {
                // 针对Edge的weight进行由小到大的排列
                return o1.weight - o2.weight;
            }
        });
        int res = 0;
        for (int i = 0; i < m; i++) {
            int px = father(edges[i].x, a); //寻找这个点属于哪一组
            int py = father(edges[i].y, a);
            if (px != py) {     //边两边的结点不属于同一组

                // 如果当前权重大于结果，那么修改结果
                if (edges[i].weight > res) {        //如果需要记录树在这记录就行
                    res = edges[i].weight;
                }

                if (px > py) {
                    // 修改a值
                    a[px] = py;
                } else {
                    a[py] = px;
                }
            }
        }
        // 打印结果
        System.out.println(res);
    }

    private static class Edge {
        int x, y;
        int weight;
        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
    public static int father(int i, int a[]) {
        int k = i;
        while (a[k] != k) {     //对这一组的进行更新
            k = a[k];
        }
        return k;
    }

}
