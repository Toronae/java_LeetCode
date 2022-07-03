package lzf.UnionFind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Code_128 {
    public static void main(String[] args) {
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(new Code_128().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        UnionFind uf = new UnionFind(nums);
        int ans = 0;

        for (int num : nums) {
            // 当num+1存在，将num合并到num+1所在集合中
            if (uf.find(num + 1) != null) {
                uf.union(num, num + 1);
            }
        }

        for (int num : nums) {
            // 找到num的最远连续右边界
            int right = uf.find(num);
            ans = Math.max(ans, right - num + 1);
        }
        return ans;
    }
    // 哈希表记录右边界
    // 建立一个哈希表，记录每个元素num能够连续到达的右边界，这样在内层循环遍历到一个新元素时，
    // 无需经过多次+1「遍历+判断」才能到达右边界，直接取值即可。

    public int longestConsecutive1(int[] nums) {
        // key表示num，value表示num最远到达的连续右边界
        Map<Integer, Integer> map = new HashMap<>();
        // 初始化每个num的右边界为自己
        for (int num : nums) {
            map.put(num, num);
        }

        int ans = 0;
        for (int num : nums) {
            if (!map.containsKey(num - 1)) {
                int right = map.get(num);
                // 遍历得到最远的右边界
                while (map.containsKey(right + 1)) {
                    right = map.get(right + 1);
                }
                // 更新右边界
                map.put(num, right);
                // 更新答案
                ans = Math.max(ans, right - num + 1);
            }

        }
        return ans;
    }

}
// 并查集模板
class UF1 {
    // 连通分量个数
    private int count;
    // 存储每个节点的父节点
    private int[] parent;

    // n 为图中节点的个数
    public UF1(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // 将节点 p 和节点 q 连通
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }
        parent[rootQ] = rootP;
        // 两个连通分量合并成一个连通分量
        count--;
    }

    // 判断节点 p 和节点 q 是否连通
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // 返回图中的连通分量个数
    public int count() {
        return count;
    }
}

class UnionFind {
    // 记录每个节点的父节点

    private Map<Integer, Integer> parent;

    public UnionFind(int[] nums) {
        parent = new HashMap<>();
        // 初始化父节点为自身
        for (int num : nums) {
            parent.put(num, num);
        }
    }

    // 寻找x的父节点，实际上也就是x的最远连续右边界，这点类似于方法2

    public Integer find(int x) {
        // nums不包含x
        if (!parent.containsKey(x)) {
            return null;
        }
        // 遍历找到x的父节点
        while (x != parent.get(x)) {
            // 进行路径压缩，不写下面这行也可以，但是时间会慢些
            parent.put(x, parent.get(parent.get(x)));
            x = parent.get(x);
        }
        return x;
    }

    // 合并两个连通分量，在本题中只用来将num并入到num+1的连续区间中

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        parent.put(rootX, rootY);
    }
}

        /*public int longestConsecutive(int[] nums) {
            Set<Integer> hash = new HashSet<Integer>();
            for(int x : nums) hash.add(x);    //放入hash表中
            int res = 0;
            for(int x : hash)
            {
                if(!hash.contains(x-1))
                {
                    int y = x;   //以当前数x向后枚举
                    while(hash.contains(y + 1)) y++;
                    res = Math.max(res, y - x + 1);  //更新答案
                }
            }
            return res;
        }*/

    /*public int longestConsecutive(int[] nums) {
        int count = 0;
        int res = 0;
        int[] temp = Arrays.stream(nums).distinct().toArray();
        Arrays.sort(temp);
        if (temp.length>0){
            int preNums = temp[0];
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] -preNums ==1){
                    count++;
                    preNums = temp[i];
                    res = Math.max(res,count);
                }else {
                    preNums = temp[i];
                    count = 0;
                }
            }
        }else {
            return 0;
        }

        return res+1;
    }*/


