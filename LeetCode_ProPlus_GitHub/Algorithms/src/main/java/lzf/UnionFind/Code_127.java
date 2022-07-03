package lzf.UnionFind;

import java.util.Arrays;

/**
 * 现有有若干家族图谱关系，给出了一些亲戚关系，如a和b是亲戚，b和c是亲戚等等，从这些信息中，你可以推出a和c是亲戚。请写一个程序，对于我们
 * 关于亲戚关系的提问，以最快速度给出答案。
 * 【输入格式】：第一部分是你n，m开始。n为人数，这些人的编号为1,2,3...n。下面有m行，每行有两个数a，b，表示a，b是亲戚
 * 第二部分是以Q开始，以下有Q行有Q个询问，每行为c，d表示询问c和d是否为亲戚
 * 【输入样例】：10,7、{{2,4},{5,7},{1,3},{8,9},{1,2},{5,6},{2,3}}
 * 3,{{3,4},{7,10},{8,9}}
 * 【输出样例】YES,NO,YES
 */
public class Code_127 {
    public static void main(String[] args) {
        int n = 10,m = 7;
        int[][] nums = {{2,4},{5,7},{1,3},{8,9},{1,2},{5,6},{2,3}};
        int[][] ans = {{3,4},{7,10},{8,9}};
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = i+1;
        }
        System.out.println(Arrays.toString(input));
        UF uf = new UF(input);
        System.out.println(uf);
        for (int[] temp:nums) {
            int a = temp[0]-1,b = temp[1]-1;
            uf.union(a,b);
        }
        for (int i = 0; i < ans.length; i++) {
            int[] temp1 = ans[i];
            int x = temp1[0]-1,y = temp1[1]-1;
            if (uf.connected(x,y)){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

}
class UF{
    private int[] parents;
    private int count;

    UF(int[] nums){
        parents = new int[nums.length];
        this.count = nums.length;
        for (int i = 0; i < nums.length; i++) {
            //关键点，这里数据要对应起来
             parents[i] = nums[i]-1;
        }
    }
    int find(int x){
        if (x == parents[x]){
            return x;
        }else {
            parents[x] = find(parents[x]);
            return parents[x];
        }
    }
    void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        parents[rootX] = rootY;
        count--;
    }
    boolean connected(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        return rootX == rootY;
    }

    private int count() {
        return this.count;
    }
}

