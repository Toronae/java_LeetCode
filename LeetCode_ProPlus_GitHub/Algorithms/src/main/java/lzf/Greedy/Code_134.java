package lzf.Greedy;

public class Code_134 {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(new Code_134().canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        for (int i = 0; i < len; i++) {
            int oilSum = 0;
            int index = i;

            while (oilSum + gas[index] - cost[index] >= 0) {
                oilSum += gas[index] - cost[index];
                index = (index + 1) % len;
                if (index == i) {
                    return i;
                }
            }
            if (index < i) {
                return -1;
            }

            i = index;
        }

        return -1;
    }
}
