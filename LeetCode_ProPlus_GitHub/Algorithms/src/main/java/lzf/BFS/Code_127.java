package lzf.BFS;

import java.util.*;

public class Code_127 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(new Code_127().ladderLength(beginWord,endWord,wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (set.isEmpty() || !set.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        int level = 1;
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                if (currWord.equals(endWord)) {
                    return level;
                }
                for (char j = 'a'; j <= 'z'; j++) {
                    for (int k = 0; k < currWord.length(); k++) {
                        String newWord = currWord.substring(0, k) + j + currWord.substring(k + 1);
                        if (set.contains(newWord)) {
                            queue.offer(newWord);
                            //避免重复访问
                            set.remove(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }

    /*public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (set.isEmpty() || !set.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int path = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                if (currWord.equals(endWord)) {
                    return path;
                }
                for (char j = 'a'; j < 'z'; j++) {
                    for (int k = 0; k < currWord.length(); k++) {
                        String newWord = currWord.substring(0,k) + j + currWord.substring(k+1);
                        if (set.contains(newWord)){
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                }
            }
            path++;
        }
        return 0;
    }*/
    /*public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList); //转换为hashset 加快速度
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {  //特殊情况判断
            return 0;
        }
        Queue<String> queue = new LinkedList<>(); //bfs 队列
        queue.offer(beginWord);
        Map<String, Integer> map = new HashMap<>(); //记录单词对应路径长度
        map.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll(); //取出队头单词
            int path  = map.get(word); //获取到该单词的路径长度
            for (int i = 0; i < word.length(); i++) { //遍历单词的每个字符
                char[] chars = word.toCharArray(); //将单词转换为char array，方便替换
                for (char k = 'a'; k <= 'z'; k++) { //从'a' 到 'z' 遍历替换
                    chars[i] = k; //替换第i个字符
                    String newWord = String.valueOf(chars); //得到新的字符串
                    if (newWord.equals(endWord)) {  //如果新的字符串值与endWord一致，返回当前长度+1
                        return path + 1;
                    }
                    if (wordSet.contains(newWord) && !map.containsKey(newWord)) { //如果新单词在set中，但是没有访问过
                        map.put(newWord, path + 1); //记录单词对应的路径长度
                        queue.offer(newWord);//加入队尾
                    }
                }
            }
        }
        return 0; //未找到
    }*/
}
