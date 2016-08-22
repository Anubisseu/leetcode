package cn.edu.seu.kse.anubis.n198_house_robber;

import java.util.Arrays;

/**
 * Created by 王彬 on 2016/8/20.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int len = nums.length;

        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }

        int[][] solution = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    solution[i][j] = nums[i];
                } else {
                    solution[i][j] = -1;
                }
            }
        }

//        System.out.println(Arrays.deepToString(solution));


        int max= max(solution, 0, len - 1);
        printArray(solution);
        return max;
    }

    public int max(int[][] solution, int l, int r) {
        if (solution[l][r] != -1) {
            return solution[l][r];
        }
        int len = r - l + 1;
        int max = -1;
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            int mid = max(solution, l + i, l + i);
            int left = 0;
            int leftr = l + i - 2;
            if (leftr >= l) {
                left = max(solution, l, leftr);
            }
            int right = 0;
            int rightl = l + i + 2;
            if (rightl <= r) {
                right = max(solution, rightl, r);
            }
            tmp = mid + left + right;

            if (max < tmp) {
                max = tmp;
            }
        }
        solution[l][r] = max;
        return max;
    }

    public void printArray(int[][] solution){
        int len=solution.length;

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                System.out.printf("%d, ",solution[i][j]);
            }
            System.out.println("");
        }
    }
}
