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
        HashMap<Character, Integer> cnt=new HashMap<>();
        HashMap<Character, Integer> find=new HashMap<>();
        List<Integer> startpos=new ArrayList<>();
        startpos.add(-1);


        int ccnt=0;
        char tmpch;
        for(int i=0;i<len;i++){
            ccnt=0;
            tmpch=t.charAt(i);
            position.put(tmpch,-1);
            if(cnt.containsKey(tmpch)){
                ccnt=cnt.get(tmpch);
            }
            cnt.put(tmpch,ccnt+1);
            find.put(tmpch,0);
        }
        int start=0, end=-1;
        len=s.length();
        boolean iscomplete=false;
        char key;
        int val;

//        System.out.println(cnt);

        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            if(find.containsKey(ch)){
                startpos.add(i);
                if(start==0){
                    start++;
                }
                ccnt=find.get(ch);
                find.put(ch,ccnt+1);

                iscomplete=true;

                while (iscomplete){
                    for(HashMap.Entry<Character,Integer> entry : find.entrySet()){
                        key=entry.getKey();
                        val=entry.getValue();

                        if(val>=cnt.get(key)){
                            continue;
                        }else {
                            iscomplete=false;
                            break;
                        }
                    }

                    if(iscomplete){
                        tmpwin=s.substring(startpos.get(start),i+1);
                        if(window.equals("") || window.length()>tmpwin.length()){
                            window=tmpwin;
                        }
                        key=tmpwin.charAt(0);
                        val=find.get(key)-1;
                        find.put(key,val);
                        start++;
                    }
//                    System.out.println(window +" " + tmpwin);
//                    System.out.println(find);
                }
            }
        }

        return window;
    }

    public int getNextStart(String s,List<Integer> startpos, HashMap<Character, Integer> cnt, int start){
        int next=start;
        char stch=s.charAt(startpos.get(start));
        int gap=cnt.get(stch);
        do{
            next++;
            if(next+gap>=startpos.size()){
                next-=1;
                break;
            }
        }
        while (isSkip(s,gap,next,stch,startpos));

        return next;
    }

    public boolean isSkip(String s, int gap, int next, char stch, List<Integer> startpos){
        boolean res=true;

        for(int i=0;i<gap;i++){
            if(stch==s.charAt(startpos.get(next+i))){
                continue;
            }else {
                res=false;
                break;
            }
        }

        return res;
    }
}
