package cn.edu.seu.kse.anubis.n76_minimum_window_substring;

import org.junit.Test;

/**
 * Created by 王彬 on 2016/8/23.
 */
public class MinWindowSubstringTest {
    @Test
    public void test(){
        String s="ADOBCECODEBANCB";
        String t="ABC";
//        String s="a";
//        String t="aa";
        MinWindowSubstring ms=new MinWindowSubstring();

        String min=ms.minWindow(s,t);

        System.out.println(min);
    }
}
