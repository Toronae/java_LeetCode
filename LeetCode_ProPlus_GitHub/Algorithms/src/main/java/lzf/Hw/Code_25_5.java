package lzf.Hw;

public class Code_25_5 {
    public static void main(String[] args) {
        String[] string = {"1","1","5","1","5","2","4","4"};
        //false代表没选中，true代表选中
        boolean flag = false;
        String res = "";
        String temp = "";
        for (int i = 0; i < string.length; i++) {
            if (string[i].equals("1")){
                if (flag){
                    res = "a";
                    flag = false;
                }else {
                    res += "a";
                }
            }else {
                if (string[i].equals("2")){
                    if (flag){
                        temp = res;
                    }
                }else if (string[i].equals("3")){
                    if (flag){
                        temp = res;
                        res = "";
                    }
                }else if (string[i].equals("4")) {
                    if (flag){
                        res = temp;
                        flag = false;
                    }else {
                        res +=temp;
                    }

                }else if (string[i].equals("5")){
                    flag = true;
                }
            }
        }
        System.out.println(res);
        System.out.println(res.length());
    }
}
