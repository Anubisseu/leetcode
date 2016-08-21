package cn.edu.seu.kse.anubis.n198_house_robber;

import org.junit.Test;

/**
 * Created by 王彬 on 2016/8/20.
 */
public class HouseRobberTest {

    @Test
    public void test(){
        int [] nums={1,2,3,4,5,6};
        HouseRobber hr=new HouseRobber();
        System.out.println(hr.rob(nums));

    }
}
