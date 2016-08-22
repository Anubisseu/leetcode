package cn.edu.seu.kse.anubis.n213_house_robber_ii;

import org.junit.Test;

/**
 * Created by 王彬 on 2016/8/21.
 */
public class HouseRobberIITest {
    @Test
    public void test(){
        int [] nums={1,2,3,4,5,6};
        HouseRobberII hr=new HouseRobberII();

        System.out.println(hr.rob(nums));
    }

}
