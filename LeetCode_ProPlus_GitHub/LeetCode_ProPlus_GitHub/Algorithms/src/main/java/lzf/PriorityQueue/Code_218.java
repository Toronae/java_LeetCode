package lzf.PriorityQueue;

import java.util.*;

public class Code_218 {
    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        System.out.println(new Code_218().getSkyline(buildings));
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // 如果将所有的建筑的边界作为一条线，那么所有的答案都在这些线上
        // 考虑任意一条线，那么这条线和所有相交的建筑（这里排除掉刚好和建筑右边界相交），取一个最高的
        // 高度，然后判断这个高度是否和ans末尾最后一个元素的高度相等，不相等就加入进去
        // 在这里为了快速得到最高的高度，使用一个堆来进行记录

        // 得到所有由建筑边界构成的边界线，并升序
        int[] boundaries = new int[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            boundaries[2 * i] = buildings[i][0];
            boundaries[2 * i + 1] = buildings[i][1];
        }
        Arrays.sort(boundaries);

        // 创建一个堆，维护一个边界-高度值对
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        List<List<Integer>> ans = new ArrayList<>(); // 返回答案
        int index = 0; // 指向buildings
        for (int boundary : boundaries) {
            // 对于一个建筑，如果其左边界在当前判断的边界线左边或重叠，那么向堆加入右边界-高度值对
            while (index < buildings.length && buildings[index][0] <= boundary) {
                pq.offer(new int[] { buildings[index][1], buildings[index][2] });
                index++;
            }

            // 对于那些加入了堆中的建筑，从堆的顶部移出建筑右边界在边界线左边或重叠的边界-高度值对
            while (!pq.isEmpty() && pq.peek()[0] <= boundary) {
                pq.poll();
            }

            // 经过上面的两步操作之后，当前边界线穿过的建筑（不含右边界）全都在堆中，并且堆的顶端是所有穿过的建筑中，高度最高的，也就是天际线高度
            // 如果此时的堆为空，证明边界线没有穿过任何建筑，来到了建筑的分割位置，天际线为0
            int maxHeight = pq.isEmpty() ? 0 : pq.peek()[1];

            // 按照这种算法，每一条边界线都会产生一个天际线高度，如果这个高度和ans末尾元素的高度一致，那么就说明两条边界线穿过了同一个建筑，并且相邻，那么按照规则只取最左端
            if (ans.size() == 0 || maxHeight != ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(boundary, maxHeight));
            }
        }

        return ans;
    }

    //
    /*public List<List<Integer>> getSkyline(int[][] bs) {
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> ps = new ArrayList<>();
        for (int[] b : bs) {
            int l = b[0], r = b[1], h = b[2];
            ps.add(new int[]{l, h, -1});
            ps.add(new int[]{r, h, 1});
        }
        *//**
         * 先严格按照横坐标进行「从小到大」排序
         * 对于某个横坐标而言，可能会同时出现多个点，应当按照如下规则进行处理：
         * 1. 优先处理左端点，再处理右端点
         * 2. 如果同样都是左端点，则按照高度「从大到小」进行处理（将高度增加到优先队列中）
         * 3. 如果同样都是右端点，则按照高度「从小到大」进行处理（将高度从优先队列中删掉）
         *//*
        Collections.sort(ps, (a, b)->{
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[2] != b[2]) return a[2] - b[2];
            if (a[2] == -1) {
                return b[1] - a[1];
            } else {
                return a[1] - b[1];
            }
        });
        // 记录进行了删除操作的高度，以及删除次数
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
        int prev = 0;
        q.add(prev);
        for (int[] p : ps) {
            int point = p[0], height = p[1], flag = p[2];
            if (flag == -1) {
                q.add(height);
            } else {
                map.put(height, map.getOrDefault(height, 0) + 1);
            }

            while (!q.isEmpty()) {
                int peek = q.peek();
                if (map.containsKey(peek)) {
                    if (map.get(peek) == 1) map.remove(peek);
                    else map.put(peek, map.get(peek) - 1);
                    q.poll();
                } else {
                    break;
                }
            }

            int cur = q.peek();
            if (cur != prev) {
                List<Integer> list = new ArrayList<>();
                list.add(point);
                list.add(cur);
                ans.add(list);
                prev = cur;
            }
        }
        return ans;
    }*/

}
