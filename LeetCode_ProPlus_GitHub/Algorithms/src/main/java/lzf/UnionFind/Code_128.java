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

