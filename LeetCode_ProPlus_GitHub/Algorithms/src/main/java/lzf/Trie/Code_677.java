package lzf.Trie;

import java.util.HashMap;

public class Code_677 {
    public static void main(String[] args) {

    }
    //前缀树 + 哈希表
    private final TrieNode root = new TrieNode();
    // 键-值 map：
    private final HashMap<String, Integer> map = new HashMap<>();

    // 前缀树节点
    private class TrieNode {
        TrieNode[] paths = new TrieNode[26];
        int sum;
    }

    public Code_677() {}

    public void insert(String key, int val) {
        // 增加量
        int delta = val;
        // 如果key已经存在，原来的键值对将被替代成新的键值对，delta为新值减老值
        if (map.containsKey(key)) {
            delta = val - map.get(key);
        }
        map.put(key, val);
        // 经典前缀树的插入代码 + 更新sum：
        TrieNode cur = root;
        cur.sum += delta;
        for (char c : key.toCharArray()) {
            if (cur.paths[c - 'a'] == null) {
                cur.paths[c - 'a'] = new TrieNode();
            }
            cur = cur.paths[c - 'a'];
            cur.sum += delta;
        }
    }

    public int sum(String prefix) {
        // 经典前缀树的搜索前缀代码：
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            cur = cur.paths[c - 'a'];
            if (cur == null) {
                return 0;
            }
        }
        return cur.sum;
    }
}
