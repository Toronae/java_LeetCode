package lzf.DFS;

import java.util.*;

public class Code_365 {
    public static void main(String[] args) {
        int jug1Capacity =3,  jug2Capacity = 5,  targetCapacity =4;
        System.out.println(new Code_365().canMeasureWater(jug1Capacity,jug2Capacity,targetCapacity));
    }
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }
        Queue<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
        AbstractMap.SimpleEntry<Integer, Integer> start = new AbstractMap.SimpleEntry<>(0, 0);
        queue.add(start);
        Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            int curX = entry.getKey();
            int curY = entry.getValue();
            if (curX == z || curY == z || curX + curY == z) {
                return true;
            }
            if (curX == 0) {
                // 把第一个桶填满
                addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(x, curY));
            }
            if (curY == 0) {
                // 把第二个桶填满
                addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX, y));
            }
            if (curY < y) {
                // 把第一个桶倒空
                addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(0, curY));
            }
            if (curX < x) {
                // 把第二个桶倒空
                addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX, 0));
            }

            // y - curY是第二个桶还可以再加的水的升数，但是最多只能加curX升水。
            int moveSize = Math.min(curX, y - curY);
            // 把第一个桶里的curX升水倒到第二个桶里去。
            addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX - moveSize, curY + moveSize));
            // 反过来同理，x - curX是第一个桶还可以再加的升数，但是最多只能加curY升水。
            moveSize = Math.min(curY, x - curX);
            // 把第一个桶里的curX升水倒到第二个桶里去。
            addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX + moveSize, curY - moveSize));
        }
        return false;
    }

    private void addIntoQueue(Queue<Map.Entry<Integer, Integer>> queue,
                              Set<Map.Entry<Integer, Integer>> visited,
                              Map.Entry<Integer, Integer> newEntry) {
        if (!visited.contains(newEntry)) {
            visited.add(newEntry);
            queue.add(newEntry);
        }
    }

    // 方法二
    public boolean canMeasureWater2(int x, int y, int z) {
        Deque<int[]> stack = new LinkedList<int[]>();
        stack.push(new int[]{0, 0});
        Set<Long> seen = new HashSet<Long>();
        while (!stack.isEmpty()) {
            if (seen.contains(hash(stack.peek()))) {
                stack.pop();
                continue;
            }
            seen.add(hash(stack.peek()));

            int[] state = stack.pop();
            int remain_x = state[0], remain_y = state[1];
            if (remain_x == z || remain_y == z || remain_x + remain_y == z) {
                return true;
            }
            // 把 X 壶灌满。
            stack.push(new int[]{x, remain_y});
            // 把 Y 壶灌满。
            stack.push(new int[]{remain_x, y});
            // 把 X 壶倒空。
            stack.push(new int[]{0, remain_y});
            // 把 Y 壶倒空。
            stack.push(new int[]{remain_x, 0});
            // 把 X 壶的水灌进 Y 壶，直至灌满或倒空。
            stack.push(new int[]{remain_x - Math.min(remain_x, y - remain_y), remain_y + Math.min(remain_x, y - remain_y)});
            // 把 Y 壶的水灌进 X 壶，直至灌满或倒空。
            stack.push(new int[]{remain_x + Math.min(remain_y, x - remain_x), remain_y - Math.min(remain_y, x - remain_x)});
        }
        return false;
    }

    public long hash(int[] state) {
        return (long) state[0] * 1000001 + state[1];
    }

    // 方法三
    // 贝祖数： ax + by = m （整数）
    // 充要条件：m是（a和b的最大公约数）的倍数
    public boolean canMeasureWater1(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        // 题目隐含条件 jug1Capacity + jug2Capacity >= targetCapacity
        if(jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        int gcd = gcd(jug1Capacity,jug2Capacity);
        return targetCapacity % gcd == 0;
    }

    // 求最大公约数
    // a和b谁大谁小无所谓，比较大小的操作已包括在里面
    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
