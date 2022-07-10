package lzf.Hwod;

/**
 * https://blog.csdn.net/csfun1/article/details/124643796?spm=1001.2014.3001.5502
 * Solo和koko是两兄弟，妈妈给了他们一大堆积木，每块积木上都有自己的重量。现在他们想要将这些积木分成两堆。哥哥Solo负责分配，弟弟koko要求两个人获得的积木总重量“相等”（根据Koko的逻辑），个数可以不同，不然就会哭，但koko只会先将两个数转成二进制再进行加法，而且总会忘记进位（每个进位都忘记）。如当25（11101）加11（1011）时，koko得到的计算结果是18（10010）：
 * 11001
 * +01011--------
 * 10010
 * Solo想要尽可能使自己得到的积木总重量最大，且不让koko哭。
 * 输入描述:
 * 3
 * 3 5 6
 * 第一行是一个整数N(2≤N≤100)，表示有多少块积木；第二行为空格分开的N个整数Ci(1≤Ci≤106)，表示第i块积木的重量。
 * 输出描述:
 * 11
 * 让koko不哭，输出Solo所能获得积木的最大总重量；否则输出“NO”。
 * 示例1
 * 输入
 * 3
 * 3 5 6
 * 输出
 * 11
 * 备注:
 * 如果能让koko不哭，输出Solo所能获得的积木的总重量，否则输出-1。
 * 该样例输出为11。
 * 解释：Solo能获得重量为5和6的两块积木，5转成二级制为101，6转成二进制位110，按照koko的计算方法（忘记进位），结果为11(二进制)。
 * Koko获得重量为3的积木，转成二进制位11(二进制)。Solo和koko得到的积木的重量都是11(二进制)。因此Solo可以获得的积木的总重量是5+6=11（十进制）。
 */
public class Code_分积木 {
    public static void main(String[] args) {
        int[] nums = {3,5,6};
        System.out.println(solution(nums));
    }

    private static String solution(int[] nums) {
        if (nums.length ==0 || nums.length==1){
            return "NO";
        }
        if(nums.length == 2 && nums[0] != nums[1]){
            return "NO";
        }
        int min = nums[0];
        int sum = min;
        int temp = min;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min,nums[i]);
            temp ^= nums[i];
        }
        if (temp!=0){
            return "NO";
        }else {
            return String.valueOf(sum-min);
        }
    }
}
