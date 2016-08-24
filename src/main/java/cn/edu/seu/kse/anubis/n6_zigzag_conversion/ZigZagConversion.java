package cn.edu.seu.kse.anubis.n6_zigzag_conversion;

/**
 * Created by 王彬 on 2016/8/24.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }



        StringBuilder[] strs=new StringBuilder[numRows];
        StringBuilder res=new StringBuilder();

        int len=s.length();

        for(int i=0;i<numRows;i++){
            strs[i]=new StringBuilder();
        }

        int rows=0;
        int step=1;
        for(int i=0;i<len;i++){
            strs[rows].append(s.charAt(i));
            if(rows == 0){step=1;}

            if(rows == numRows-1){step=-1;}
            rows+=step;
        }

        for(StringBuilder sb:strs){
            res.append(sb.toString());
        }
        return res.toString();
    }


    public String convert1(String s, int numRows) {
        if(numRows==1){
            return s;
        }

        if(s.equals("")){
            return s;
        }

        int zline= 0;

        int len=s.length();
        int rowsize=0;
        boolean isz=true;
        int gap=0;

        if(numRows%2==0){
            zline=0;
            rowsize=(int) Math.ceil(len/(numRows*1.0));
            gap=numRows;
            isz=false;
        }else {
            zline= (int) Math.ceil(numRows/2.0)-1;
            rowsize= (int) Math.ceil(len/(numRows+1.0));
            isz=true;
            gap=numRows+1;
        }
//        rowsize=2*rowsize-1;

//        System.out.printf("zline %d, slen %d, rowsize %d %n",zline,len,rowsize);

        StringBuilder sb=new StringBuilder();
        int pos=0;
        for(int i=0;i<numRows;i++){
            for(int j=0;j<rowsize;j++){
                pos=i+j*gap;
                if(pos>=len){
                    break;
                }
//                System.out.printf("i %d, j %d, pos %d, char %s%n",i,j,pos,s.charAt(pos));

                sb.append(s.charAt(pos));
                if(i==zline && isz){
                    pos=(numRows+1)*j+numRows;
                    if(pos>=len){
                        break;
                    }
                    sb.append(s.charAt(pos));
//                    System.out.printf("zline i %d, j %d, pos %d, char %s%n",i,j,pos,s.charAt(pos));
                }
            }
        }

        return sb.toString();
    }
}
