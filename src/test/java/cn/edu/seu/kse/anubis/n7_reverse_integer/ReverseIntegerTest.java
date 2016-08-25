package cn.edu.seu.kse.anubis.n7_reverse_integer;

import org.junit.Test;

/**
 * Created by 王彬 on 2016/8/25.
 */
public class ReverseIntegerTest {

    @Test
    public void test(){
        int[] nums={1, 234,-4324,2333,-43244,0,2974803,1534236469};

        ReverseInteger ri=new ReverseInteger();

        for(int i:nums){
            System.out.printf("origin %d, reverse %d %n", i, ri.reverse(i));
        }
    }
}
