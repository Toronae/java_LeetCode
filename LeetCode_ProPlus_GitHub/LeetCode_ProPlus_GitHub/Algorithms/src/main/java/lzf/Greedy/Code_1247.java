package lzf.Greedy;

public class Code_1247 {
    public static void main(String[] args) {
        String s1 = "xy";
        String s2 = "yy";
        System.out.println(new Code_1247().minimumSwap(s1,s2));
    }
    public int minimumSwap(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return -1;
        }
        int x = 0, y = 0;
        for(int i = 0; i < s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(s1.charAt(i) == 'x'){
                    x++;
                }else {
                    y++;
                }
            }
        }
        if((x + y) % 2 == 1){
            return -1;
        }
        int res = (x/2) + (y/2) + (x%2)*2;
        return res;
    }
}
