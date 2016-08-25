package cn.edu.seu.kse.anubis.n7_reverse_integer;

/**
 * Created by 王彬 on 2016/8/25.
 */
public class ReverseInteger {
    public int reverse(int x){
        if(x>0){
            return reversePosiveInteger(x);
        }else if(x<0){
            return -reversePosiveInteger(-x);
        }else {
            return x;
        }
    }

    public int reversePosiveInteger(int x){
        int res=0;

        while (x!=0){
            res+=x%10;
            x/=10;

            if(x!=0){
                if(res!=0&&Integer.MAX_VALUE/res<10){
                    res=0;
                    break;
                }
                res*=10;
            }
        }

        return res;
    }
}
