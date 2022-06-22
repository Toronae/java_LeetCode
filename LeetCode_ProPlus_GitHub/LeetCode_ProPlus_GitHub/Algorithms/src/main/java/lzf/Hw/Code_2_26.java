package lzf.Hw;

public class Code_2_26 {
    public static void main(String[] args) {
//        String input = "/acm,/bb";
//        String input = "/acm/,///bb";
        String input = "/acm/,bb";
        System.out.println(strAppend(input));
    }

    private static String strAppend(String input) {
        StringBuilder sb = new StringBuilder();
        String[] str = input.split(",");
        for (String temp : str) {
            if (!temp.startsWith("/")){
                sb.append("/").append(temp);
            }else {
                sb.append(temp);
            }
        }
        String res = sb.toString();
        String newRes = res.replaceAll("\\//+","/");
        return newRes;
    }
}
