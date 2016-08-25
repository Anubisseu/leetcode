package cn.edu.seu.kse.anubis.n367_valid_perfect_square;

import java.util.HashSet;
import java.util.InputMismatchException;

/**
 * Created by 王彬 on 2016/8/25.
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num){
        boolean res=lowEndValidate(num);
        if(res==false){
            return res;
        }

        int powl=0;
        int powr=1;
        int i=0;

        while (true){
            i++;
            powr=i*i;

            if(powr/i!=i){
                res=false;
                break;
            }

            if(powl==num){
                res=true;
                break;
            }else if(num < powr){
                res=false;
                break;
            }

            powl=powr;
        }


        return res;
    }

    public boolean lowEndValidate(int num){
        int low=num%10;
        int[] nums={0,1,4,5,6,9};
        HashSet<Integer> valid=new HashSet<>();
        for(int n:nums){
            valid.add(n);
        }

        if(valid.contains(low)){
            return true;
        }else {
            return false;
        }
    }
}
