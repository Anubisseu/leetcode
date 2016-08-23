package cn.edu.seu.kse.anubis.n76_minimum_window_substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by 王彬 on 2016/8/23.
 */
public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        String window="";
        String tmpwin="";
        int len=t.length();
        HashMap<Character,Integer> position=new HashMap<>();
        List<Integer> startpos=new ArrayList<>();
        startpos.add(-1);


        for(int i=0;i<len;i++){
            position.put(t.charAt(i),-1);
        }
        int start=0, end=-1;
        len=s.length();
        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            if(position.containsKey(ch)){
                startpos.add(i);
                if(start==0){
                    start++;
                }else if(ch==s.charAt(startpos.get(start))){
                    start=getNextStart(s,startpos,start);
                }
                position.put(ch,i);

                if(!position.containsValue(-1)){
                    tmpwin=s.substring(startpos.get(start),i+1);
                    if(window.equals("") || window.length()>tmpwin.length()){
                        window=tmpwin;
                    }
                    position.put(s.charAt(startpos.get(start)), -1);
                    start=getNextStart(s,startpos,start);
                }
            }
        }

        return window;
    }

    public int getNextStart(String s,List<Integer> startpos, int start){
        int next=start;
        do{
            next++;
            if(next==startpos.size()){
                next-=1;
                break;
            }
        }
        while (s.charAt(startpos.get(next)) == s.charAt(startpos.get(start)));

        return next;
    }
}
