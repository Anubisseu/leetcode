package cn.edu.seu.kse.anubis.n6_zigzag_conversion;

import org.junit.Test;

/**
 * Created by 王彬 on 2016/8/24.
 */
public class ZigZagConversionTest {
    @Test
    public void test(){
        String s="PAYPALISHIRING";
        int nRows=3;
//        String s="ABCD";
//        int nRows=2;
        String res="PAHNAPLSIIGYIR";
        ZigZagConversion zc=new ZigZagConversion();
        System.out.println(zc.convert(s,nRows));
        System.out.println(res);
    }

    @Test
    public void testMathCeil(){
        System.out.println(Math.ceil(5/2.0));
        System.out.println(Math.ceil(4/2.0));
    }
}
