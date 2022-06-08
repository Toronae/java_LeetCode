package lzf.DivideConquer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Code_932 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(Arrays.toString(new Code_932().beautifulArray(n)));
    }

    private Map<Integer, int[]> memory = new HashMap();
    public int[] beautifulArray(int n) {
        int[] temp = memory.get(n);
        if(temp != null) {
            return temp;
        }

        int[] result = new int[n];

        int i = 0;

        if(n != 1){
            // 这里注意哈 (n + 1) / 2 + n / 2 = n 整数除法有个向下取整
            // 所以当n为奇数时 左半区元素比右边要多一个 习惯就好
            for(int num : beautifulArray((n + 1)/ 2)){
                result[i++] = num * 2 - 1;
            }

            for(int num : beautifulArray(n / 2)){
                result[i++] = num * 2;
            }
        } else {
            result[0] = 1;
        }
        // 之所以 n != 1放前面 是因为 当记忆化之后 这个else几乎不会运行到 所以放前面

        memory.put(n, result);
        return result;
    }

}
