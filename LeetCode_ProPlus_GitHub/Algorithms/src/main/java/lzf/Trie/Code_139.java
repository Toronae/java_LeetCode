package lzf.Trie;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Code_139 {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new Code_139().wordBreak(s,wordDict));
    }
    // 字典树
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();

        for (String word : wordDict) {
            trie.insert(word.toCharArray());
        }
        return trie.find(s, 0);
    }

    class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }

    class Trie {
        private TrieNode root = new TrieNode('/');
        boolean[] failed = new boolean[301]; // s.length <= 300

        public void insert(char[] text) {
            TrieNode p = root;
            for (int i = 0; i < text.length; ++i) {
                int index = text[i] - 'a';
                if (p.children[index] == null) {
                    TrieNode newNode = new TrieNode(text[i]);
                    p.children[index] = newNode;
                }
                p = p.children[index];
            }
            p.isEndingChar = true;
        }

        public boolean find(String s, int i) {
            if (failed[i]) {
                return false;
            }
            if (i >= s.length()) {
                return true;
            }
            TrieNode p = root;
            for (; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (p.children[index] == null) {
                    return false;
                }
                p = p.children[index];
                if (p.isEndingChar) {
                    if (find(s, i + 1)) {
                        return true;
                    }
                    failed[i + 1] = true;
                }
            }
            return false;
        }
    }
    //dp
    /*public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }*/
}
