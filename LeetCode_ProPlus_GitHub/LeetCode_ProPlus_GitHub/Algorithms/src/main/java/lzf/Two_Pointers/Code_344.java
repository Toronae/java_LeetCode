package lzf.Two_Pointers;

public class Code_344 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        System.out.println(new Code_344().reverseString(s));
    }
    public char[] reverseString(char[] s) {
        int left = 0;
        int rigth = s.length-1;
        while (left < rigth) {
            char t = s[left];
            s[left] = s[rigth];
            s[rigth] = t;
            left++;
            rigth--;
        }
        return s;
    }
    /*public void reverseString(char[] s) {
        int left = 0;
        int rigth = s.length-1;
        while (left < rigth) {
            char t = s[left];
            s[left] = s[rigth];
            s[rigth] = t;
            left++;
            rigth--;
        }
    }*/
}
