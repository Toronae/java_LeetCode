package lzf.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Code_933 {
    public static void main(String[] args) {

    }

    Queue<Integer> queue;
    public Code_933() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty() && t-queue.peek()>3000){
            queue.poll();
        }
        return queue.size();
    }
}
