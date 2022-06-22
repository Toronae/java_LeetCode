package lzf.Matrix;

import java.util.Arrays;

public class Code_832 {
    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(Arrays.deepToString(new Code_832().flipAndInvertImage(image)));
    }
    //双指针 加 交换反转
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0;i<image.length;i++){
            int[] nums=image[i];
            int l=0,r=nums.length-1;
            while(l<=r){
                reverse(nums,l,r);
                l++;r--;
            }
        }
        return image;

    }
    public void reverse(int[] nums,int i,int j){
        int temp=-nums[i]+1;
        nums[i]=-nums[j]+1;
        nums[j]=temp;
    }

}
