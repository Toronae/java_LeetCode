package lzf.Hwod;

import java.util.*;

/**
 * 有一堆长方体积木，它们的宽度和高度都相同，但长度不一。小橙想把这堆积木叠成一面墙，墙的每层可以放一个积木，
 * 也可以将两个积木拼接起来，要求每层的长度相同。若必须用完这些积木，叠成的墙最多为多少层？
 * 如下是叠成的一面墙的图示，积木仅按宽和高所在的面进行拼接。
 * 输入描述:
 * 输入为一行，为各个积木的长度，数字为正整数，并由空格分隔。积木的数量和长度都不超过5000。
 * 输出描述:
 * 输出一个数字，为墙的最大层数，如果无法按要求叠成每层长度一致的墙，则输出-1。
 * 示例1
 * 输入
 * 3 6 6 3
 * 输出
 * 3
 * 说明
 * 可以每层都是长度3和6的积木拼接起来，这样每层的长度为9，层数为2；也可以其中两层直接用长度6的积木，两个长度3的积木拼接为一层，这样层数为3，故输出3。
 * 示例2
 * 输入
 * 1 4 2 3 6
 * 输出
 * -1
 * 说明
 * 无法用这些积木叠成每层长度一致的墙，故输出-1。
 * 解题思路：
 * 每层只能放一个或两个积木（非常重要）
 * 积木的总长度可以被积木层数整除
 * 积木每层的最小长度为最短积木，最大长度为最短积木和最大积木和（因为一层最多两个积木）
 * 根据步骤2对总长度进行分解因子，从最小长度开始，如果因数符合积木要求，则输出层数；如不符合，则输出-1
 */
public class Code_叠积木 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");

        List<Integer> list = new ArrayList<>();
        int count = 0;  //积木总长度
        int len = strings.length;

        for(int i=0;i<len;i++){
            int n = Integer.valueOf(strings[i]);
            count +=n;
            list.add(n);    //所有积木集合
        }

        Collections.sort(list);
        int min = list.get(len-1);  //最小宽度
        int max = list.get(0) + list.get(len-1);    //最大宽度（因为最多是两个积木拼接）
        int res = -1;

        for(int i=min;i<=max;i++){
            if(count%i==0){
                List<Integer> copyList = copyArr(list); //因为要多list进行多次操作
                if(isSuccess(copyList,i)){
                    res = count/i;
                    break;
                }
            }
        }

        System.out.println(res);
    }

    public static List<Integer> copyArr(List<Integer> list){

        int len = list.size();
        List<Integer> copyList = new ArrayList<>();

        for(int i=0;i<len;i++){
            copyList.add(list.get(i));
        }

        return copyList;
    }

    /**
     *
     * @param list 积木集合
     * @param n 积木所需宽度
     * @return
     */
    public static Boolean isSuccess(List<Integer> list,int n){

        boolean isTrue = true;

        while (list.size()>0 && isTrue){
            int i = list.size()-1;
            if(n==list.get(i)){
                list.remove(i); //最长的一根积木符合要求则剔除进行下次循环
            }else if(n==list.get(i)+list.get(0)){
                list.remove(i); //最长一根跟最短一根积木之和符合要求则剔除两个积木进行下次循环
                list.remove(0);
            }else {
                isTrue = false; //上面两个都不符合则表示无法完成一堵墙
            }
        }

        return isTrue;
    }
    //满分代码
    /*private static int[] arr;
    private static boolean[] isUsed;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        arr = new int[strs.length];
        isUsed = new boolean[strs.length];
        int i = 0;
        for (i = 0; i < strs.length; i += 1) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(arr);
        int max1 = 0, max2 = 0;
        max1 = getLevel(arr[arr.length - 1]);
        max2 = getLevel(arr[arr.length - 1] + arr[0]);
        System.out.println(Math.max(max1, max2));
    }

    private static int getLevel(int levelLength) {
        int maxLength = 0;
        int i = 0, j = 0, k = 0;
        for (i = arr.length - 1; i > 0; i -= 1) {
            if (arr[i] == levelLength) {
                maxLength += 1;
                isUsed[i] = true;
                continue;
            }
            if (!isUsed[i]) {
                for (j = 0; j < i; j += 1) {
                    if (arr[i] + arr[j] == levelLength && (!isUsed[j])) {
                        maxLength += 1;
                        isUsed[i] = true;
                        isUsed[j] = true;
                        break;
                    }
                }
                if (j == i) {
                    for (i = 0; i < arr.length; i += 1) {
                        isUsed[i] = false;
                    }
                    return -1;
                }
            }
        }
        if (arr[0] == levelLength) {
            maxLength += 1;
        }
        for (i = 0; i < arr.length; i += 1) {
            if (!isUsed[i]) {
                maxLength = -1;
            }
            isUsed[i] = false;
        }
        return maxLength;
    }*/
}
