package lzf.Zix.Stream;

import java.util.Arrays;

public class stream {
    public static void main(String[] args) {
        //将int[]转换成string[]
        int[] nums = {1,2,3,4,5};
        String[] str = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);

    }
}
