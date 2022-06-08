package lzf.Queue;

public class Code_1687 {
    public static void main(String[] args) {
        int[][] boxes = {{1,2},{2,1},{1,1}};
        int portsCount = 2;
        int maxBoxes = 3;
        int maxWeight = 3;
        System.out.println(new Code_1687().boxDelivering(boxes,portsCount,maxBoxes,maxWeight));
    }
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int [] dp = new int [boxes.length + 1];
        dp[1] = 2;
        int trip = 2;
        int load = boxes[0][1];
        int b = 1;
        for(int i = 0, j = 1; j < boxes.length; j++){
            load += boxes[j][1];
            b++;
            if (boxes[j][0] != boxes[j-1][0]) {
                trip++;
            }
            while(load > maxWeight || b > maxBoxes || dp[i+1] == dp[i]){
                b--;
                load -= boxes[i++][1];
                if (boxes[i][0] != boxes[i-1][0] ){
                    trip--;
                }
            }
            dp[j+1] = dp[i] + trip;

        }
        return dp[boxes.length];
    }
}
