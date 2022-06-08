package lzf.Greedy;

public class Code_1217 {
    public static void main(String[] args) {
        int[] position = {1, 2, 3};
        System.out.println(new Code_1217().minCostToMoveChips(position));
    }

    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                odd++;
            } else {
                even++;
            }
        }
        return Math.min(odd, even);
    }
}
