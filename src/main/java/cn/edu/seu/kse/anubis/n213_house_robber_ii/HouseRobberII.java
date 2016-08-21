package cn.edu.seu.kse.anubis.n213_house_robber_ii;

/**
 * Created by 王彬 on 2016/8/21.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int max=0;

        if (nums == null) {
            return 0;
        }

        int len = nums.length;

        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }

        //不跨界结果
        int[][] csolution = new int[len][len];
        //跨界结果
        int[][] ncsolution = new int[len][len];

        return max;
    }


}
