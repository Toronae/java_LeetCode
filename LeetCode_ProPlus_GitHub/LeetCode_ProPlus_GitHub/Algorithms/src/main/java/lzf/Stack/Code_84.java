package lzf.Stack;

import java.util.Stack;

public class Code_84 {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(new Code_84().largestRectangleArea(heights));
    }
    public int largestRectangleArea(int[] heights) {
        // 0 1 2 3 4 5 6 7
        // 0 2 1 5 6 2 3 0
        if (heights == null) {
            return 0;
        }
        if (heights.length == 1){
            return heights[0];
        }
        int[] ab = new int[heights.length+2];
        Stack<Integer> stack = new Stack<>();
        //在柱体数组的头和尾加了两个高度为 0 的柱体
        System.arraycopy(heights,0,ab,1,heights.length);
        int area = 0;
        for (int i = 0; i < ab.length; i++) {
            // 当栈为空或者当前值大于栈顶值时，压栈
            if (stack.empty() || ab[i] >= ab[stack.peek()]){
                stack.push(i);
            }else if (ab[i] < ab[stack.peek()]){
                // 当栈不为空或者当前值小于栈顶值时，弹栈
                while (!stack.empty() && ab[i] <ab[stack.peek()]) {
                    int cur_heigth = ab[stack.peek()];
                    stack.pop();
                    int cur_width = i-stack.peek()-1;
                    area = Math.max(area,cur_heigth*cur_width);
                }
                stack.push(i);
            }
        }
        return area;
    }
}
