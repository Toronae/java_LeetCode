package lzf.Two_Pointers;

import java.util.Arrays;

public class Code_881 {
    public static void main(String[] args) {
        int limit = 3;
        int[] people = {3,2,2,1};
        System.out.println(new Code_881().numRescueBoats(people,limit));
    }

    // 双指针
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0,j=people.length-1;
        int res=0;
        while(i<=j){
            // 每艘船最多可同时载两人
            if(people[i]+people[j]<=limit){
                res++;// 装(i,j)
                i++;
                j--;
            }else{
                res++;// 装j
                j--;
            }

        }
        return res;
    }

    /*public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1, res = 0;
        while (left <= right) {
            res++;
            if (left == right) {
                break;
            }
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
        }
        return res;
    }*/

    // 贪心
    /*public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int l = 0, r = n - 1;
        int ans = 0;
        while (l <= r) {
            if (people[l] + people[r] <= limit) l++;
            r--;
            ans++;
        }
        return ans;
    }*/
}
