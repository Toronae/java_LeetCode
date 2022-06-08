package lzf.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code_131 {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new Code_131().partition(s));
    }

    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backTracking(s,0);
        return res;
    }

    private void backTracking(String s, int startIndex) {
        // 如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()){
            res.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 如果是回文子串，则记录
            if (isPalindrome(s,startIndex,i)){
                String str = s.substring(startIndex,i+1);
                path.addLast(str);
            }else {
                continue;
            }
            // 起始位置后移，保证不重复
            backTracking(s,i+1);
            path.removeLast();
        }
    }

    // 判断是否是回文串
    
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++,j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
