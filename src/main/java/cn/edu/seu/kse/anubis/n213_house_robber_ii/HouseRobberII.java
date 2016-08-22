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

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i == j){
                    csolution[i][j]=nums[i];
                }else {
                    csolution[i][j]=-1;
                }
            }
        }

//        for(int i=0;i<len;i++){
//            for(int j=i;j<len;j++){
//
//                System.out.printf("i %d, j %d %n", i,j);
//                max=max(csolution,i,j);
//                System.out.printf("i %d, j %d, max %d %n", i,j,max);
//            }
//        }


        max=max(csolution,null,null);



        return max;
    }

    public int max(int[][] solution, Integer l, Integer r){
        int max=-1;
        int tmp=0;
        int len=solution.length;
        int leftr=0;
        int rightl=0;
        int mid=0;
        int left=0;
        int right=0;
        int gap=0;

        int mids=0;
//        System.out.printf("max left %d, right %d %n",l,r);

        if(l==null && r==null){
            for(int i=0;i<len;i++){
                leftr=i-2;
                if(leftr<0){
                    leftr+=len;
                }

                rightl=i+2;
                if(rightl>len-1){
                    rightl-=len;
                }

//                System.out.printf("circle  left %d, right %d, mid %d%n", rightl,leftr,i);
                tmp=max(solution,rightl,leftr)+solution[i][i];


                if(tmp>max){
                    max=tmp;
                }
            }
        }
        else if(l>r){
            max=solution[l][r];
            if(max!=-1){
                return max;
            }

            gap=len-l+r;

            for(int i=0;i<gap;i++){
                mids=l+i;
                leftr=mids-2;
                rightl=mids+2;

                if(mids>=len){
                    mids-=len;
                }

                if(leftr>=len){
                    leftr-=len;
//                    System.out.printf("l>r  left %d, right %d, mid %d%n", l,leftr,mids);
                    left=max(solution,l,leftr);
                }else if(leftr<l) {
                    left=0;
                }else {
//                    System.out.printf("l>r  left %d, right %d, mid %d%n", l,leftr,mids);
                    left=max(solution,l,leftr);
                }

                if(rightl>=len){
                    rightl-=len;
                    if(rightl>r){
                        right=0;
                    }else {
//                        System.out.printf("l>r  left %d, right %d, mid %d%n", rightl,r,mids);
                        right=max(solution,rightl,r);
                    }
                }else {
//                    System.out.printf("l>r  left %d, right %d, mid %d%n", rightl,r,mids);
                    right=max(solution,rightl,r);
                }
//                System.out.printf("l>r  left %d, right %d, mid %d%n", mids,mids,mids);
                mid=max(solution, mids, mids);
                tmp=left+mid+right;
                if (tmp>max){
                    max=tmp;
                }

            }
            solution[l][r]=max;
        }else if(l<r) {
            max=solution[l][r];
            if(max!=-1){
                return max;
            }
            gap=r-l+1;

            for(int i=0;i<gap;i++){
                mids=l+i;
                leftr=mids-2;
                rightl=mids+2;

                if(leftr<l){
                    left=0;
                }else {
                    left=max(solution,l,leftr);
                }

                if(rightl>r){
                    right=0;
                }else {
                    right=max(solution,rightl,r);
                }

                mid=solution[mids][mids];
                tmp=left+mid+right;
                if(max<tmp){
                    max=tmp;
                }

            }
            solution[l][r]=max;
        }else {
            max=solution[l][r];
        }

        return max;
    }

}
