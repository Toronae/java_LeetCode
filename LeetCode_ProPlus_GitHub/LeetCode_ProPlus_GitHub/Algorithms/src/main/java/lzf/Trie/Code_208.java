package lzf.Trie;

import sun.text.normalizer.Trie;

import java.util.HashSet;
import java.util.Set;

public class Code_208 {
    public static void main(String[] args) {

    }

    private Set<String> data = new HashSet<>();

    public Code_208() {
    }

    public void insert(String word) {
        data.add(word);
    }

    public boolean search(String word) {
        return data.contains(word);
    }

    public boolean startsWith(String prefix) {
        if (data.contains(prefix)) {
            return true;
        }
        for (String myVar : data) {
            if (myVar.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

    // 字典树实现
    /*private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }*/
}
