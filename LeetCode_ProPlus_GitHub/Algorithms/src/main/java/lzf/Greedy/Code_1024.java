package lzf.Greedy;

public class Code_1024 {
    public static void main(String[] args) {
        int[][] clips = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        int T = 10;
        System.out.println(new Code_1024().videoStitching(clips,T));
    }
    public int videoStitching(int[][] clips, int T) {
        if (clips == null) {
            return 0;
        }
        // 用于保存 以当前数字(下标)为起点 的区间的 最大的结束位置
        int[] maxEnd = new int[T];

        /*
            遍历clips，初始化maxEnd数组(每个元素开头的区间的最大结束位置)
         */
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxEnd[clip[0]] = Math.max(maxEnd[clip[0]], clip[1]);
            }
        }

        /*
            根据maxEnd数组，计算最终结果
                因为maxEnd[i]数组为最大结束位置，因此：
                    1、当前元素 == 本区间最大元素，
                        即：区间断开，无法连续到后续位置，返回-1
                    2、当前元素 == 上一个区间的最大结束元素，
                        即：到达了上一个满足条件的区间的结束位置
                        这时的last为当前最大的结束位置，我们将其放入满足条件的区间集合之中
                        (因为本题只需要我们记录 满足条件的区间个数，因为只需要 更新count和pre 即可)
         */
        // 记录 结果中上一次的最大结束位置(本轮的最小开始位置)
        int pre = 0;
        // 记录当前遍历到的 区间最大结束位置
        int last = 0;
        // 记录结果
        int count = 0;
        for (int i = 0; i < T; i++) {
            last = Math.max(maxEnd[i], last);
            // 当前元素 == 本区间最大元素(无法到达后续位置)
            if (i == last) {
                return -1;
            }
            // 当前元素 == 上一个区间的最大元素
            if (i == pre) {
                count++;
                pre = last;
            }
        }
        return count;
    }
}
