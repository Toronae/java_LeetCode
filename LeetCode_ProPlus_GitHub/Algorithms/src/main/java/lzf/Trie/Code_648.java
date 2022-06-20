package lzf.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Code_648 {
    public static void main(String[] args) {
        String sentence= "the cattle was rattled by the battery";
        List<String> roots = new ArrayList<>();
        roots.add("cat");
        roots.add("bat");
        roots.add("rat");
        System.out.println(new Code_648().replaceWords(roots,sentence));
    }
    //前缀树
    public String replaceWords(List<String> roots, String sentence) {
        TrieNode trie = new TrieNode();
        for (String root: roots) {
            TrieNode cur = trie;
            for (char letter: root.toCharArray()) {
                if (cur.children[letter - 'a'] == null){
                    cur.children[letter - 'a'] = new TrieNode();
                }
                cur = cur.children[letter - 'a'];
            }
            cur.word = root;
        }

        StringBuilder ans = new StringBuilder();

        for (String word: sentence.split("\\s+")) {
            if (ans.length() > 0) {
                ans.append(" ");
            }
            TrieNode cur = trie;
            for (char letter: word.toCharArray()) {
                if (cur.children[letter - 'a'] == null || cur.word != null){
                    break;
                }
                cur = cur.children[letter - 'a'];
            }
            ans.append(cur.word != null ? cur.word : word);
        }
        return ans.toString();
    }
}

class TrieNode {
    TrieNode[] children;
    String word;
    TrieNode() {
        children = new TrieNode[26];
    }

    // 前缀哈希
    public String replaceWords1(List<String> roots, String sentence) {
        Set<String> rootset = new HashSet();
        for (String root: roots) {
            rootset.add(root);
        }

        StringBuilder ans = new StringBuilder();
        for (String word: sentence.split("\\s+")) {
            String prefix = "";
            for (int i = 1; i <= word.length(); ++i) {
                prefix = word.substring(0, i);
                if (rootset.contains(prefix)) {
                    break;
                }
            }
            if (ans.length() > 0) {
                ans.append(" ");
            }
            ans.append(prefix);
        }
        return ans.toString();
    }
}
