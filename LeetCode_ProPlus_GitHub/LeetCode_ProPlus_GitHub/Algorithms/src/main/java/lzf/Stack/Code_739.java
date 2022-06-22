package lzf.Stack;

import java.util.Arrays;
import java.util.Stack;

public class Code_739 {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(new Code_739().dailyTemperatures(temperatures)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                res[preIndex] = i-preIndex;
            }
            stack.push(i);
        }
        return res;
    }
}
