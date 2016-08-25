package cn.edu.seu.kse.anubis.n367_valid_perfect_square;

import org.junit.Test;

/**
 * Created by 王彬 on 2016/8/25.
 */
public class ValidPerfectSquareTest {
    @Test
    public void test(){
        int[] nums={0,1,3,423423432,144,10000,232400001,93025};

        ValidPerfectSquare vpf=new ValidPerfectSquare();

        for(int n:nums){
            System.out.printf("origin %d, sqrt %f, isPF %b%n", n, Math.sqrt(n),vpf.isPerfectSquare(n));
        }

    }

}
