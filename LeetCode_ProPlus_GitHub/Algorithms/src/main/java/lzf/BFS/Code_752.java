package lzf.BFS;

import java.util.*;

public class Code_752 {
    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(new Code_752().openLock(deadends,target));
    }
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        Set<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        if (dead.contains("0000")){
            return -1;
        }
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        while(!queue.isEmpty()){
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                for (String nextStatus:get(status)) {
                    if (!visited.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (nextStatus.equals(target)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        visited.add(nextStatus);
                    }
                }
            }
        }
        return -1;
    }

    // 枚举 status 通过一次旋转得到的数字

    private List<String> get(String status) {
        List<String> ret = new ArrayList<>();
        char[] chars = status.toCharArray();
        for (int i = 0; i < 4; i++) {
            char num = chars[i];
            chars[i] = numPrev(num);
            ret.add(new String(chars));
            chars[i] = numNext(num);
            ret.add(new String(chars));
            chars[i] = num;
        }
        return ret;
    }

    private char numNext(char num) {
        return num == '0' ? '9' : (char) (num+1);
    }

    private char numPrev(char num) {
        return num == '9' ? '0' : (char) (num+1);
    }

    //
    /*public int openLock(String[] deadends, String target) {
        // 记录死亡数字，方便快速判断
        Set<String> deadendSet = new HashSet<>();
        for (String deadend : deadends) deadendSet.add(deadend);
        // 和层次遍历中的队列作用一样
        Queue<String> q = new LinkedList<>();
        // 记录访问情况
        Set<String> visited = new HashSet<>();
        int step = 0;
        // 添加起始数字
        q.offer("0000");
        // 标记为已访问
        visited.add("0000");
        while (!q.isEmpty()) {
            int sz = q.size();
            // 一层一层的遍历
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                // 访问「死亡数字」时，跳过
                if (deadendSet.contains(cur)) continue;
                // 找到目标，结束
                if (cur.equals(target)) return step;
                // 存储孩子节点到队列中，分 4 次
                for (int j = 0; j < 4; j++) {
                    // +1
                    String pushOne = increaseOne(cur, j);
                    // -1
                    String minusOne = decreaseOne(cur, j);
                    // 如果没有访问过
                    if (!visited.contains(pushOne)) {
                        // 加入队列
                        q.offer(pushOne);
                        // 标记为已访问
                        visited.add(pushOne);
                    }
                    // 同上
                    if (!visited.contains(minusOne)) {
                        q.offer(minusOne);
                        visited.add(minusOne);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    // +1
    private String increaseOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '9') {
            ch[i] = '0';
        }else{
            ch[i] += 1;
        }
        return new String(ch);
    }
    // -1
    private String decreaseOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '0') {
            ch[i] = '9';
        } else {
            ch[i] -= 1;
        }
        return new String(ch);
    }*/

}
