package lzf.Stack;

import java.util.Stack;

public class Code_901 {
    public static void main(String[] args) {

    }
    Stack<Integer> prices, weiths;
    public Code_901() {
        prices = new Stack<>();
        weiths = new Stack<>();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weiths.pop();
        }
        prices.push(price);
        weiths.push(w);
        return w;
    }
}
