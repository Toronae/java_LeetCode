package lzf.Trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Code_820 {
    public static void main(String[] args) {

    }
    public int minimumLengthEncoding(String[] words) {
        TrieNode1 trie = new TrieNode1();
        Map<TrieNode1, Integer> nodes = new HashMap<>();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode1 cur = trie;
            for (int j = word.length() - 1; j >= 0; --j) {
                cur = cur.get(word.charAt(j));
            }
            nodes.put(cur, i);
        }

        int ans = 0;
        for (TrieNode1 node: nodes.keySet()) {
            if (node.count == 0) {
                ans += words[nodes.get(node)].length() + 1;
            }
        }
        return ans;

    }
}

class TrieNode1 {
    TrieNode1[] children;
    int count;

    TrieNode1() {
        children = new TrieNode1[26];
        count = 0;
    }

    public TrieNode1 get(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode1();
            count++;
        }
        return children[c - 'a'];
    }
}

/*class Solution {
    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        // 先对单词列表根据单词长度由长到短排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        // 单词插入trie，返回该单词增加的编码长度
        for (String word: words) {
            len += trie.insert(word);
        }
        return len;
    }
}

// 定义tire
class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public int insert(String word) {
        TrieNode cur = root;
        boolean isNew = false;
        // 倒着插入单词
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                isNew = true; // 是新单词
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        // 如果是新单词的话编码长度增加新单词的长度+1，否则不变。
        return isNew? word.length() + 1: 0;
    }
}

class TrieNode {
    char val;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {}
}*/


