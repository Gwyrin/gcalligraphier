/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcalligraphier.wrk;

import gcalligraphier.bean.Params;
import java.util.ArrayList;

/**
 *
 * @author Vincent
 */
public class Worker {
    
    public String caligraph(String text, Params p){
        String[] str = null;
        switch(p.getMode()){
            case "Characters":
                char[] c = text.toCharArray();
                str = new String[c.length];
                for (int i = 0; i < c.length; i++) {
                    str[i] = Character.toString(c[i]);
                }
            break;
            case "Words":
                str = text.split(" ");
                break;
            case "Paragraphs":
                str = text.split("(?=\n)");
                break;
            case "Text":
                str = new String[1];
                str[0] = text;
                break;
        }
        
        String result = "<meta charset=\"UTF-8\"><p>";
        for (String s : str) {
             String[] s2 = null;
            if (s.contains("\n")){
                 s2 = s.split("(?=\n)");
            }else{
                s2 = new String[]{s};
            }
            for (String st : s2) {
                result+= "<span style='color:"+getRandomColor(p.getMaxR(), p.getMinR(), p.getMaxG(), p.getMinG(), p.getMaxB(), p.getMinB())
                +"; font-size:"+getRandomSize(p.getMinSize(), p.getMaxSize())
                +";font-family:"+(p.isRandomfonts()? getRandomFontfamily() : "Arial")+";'>"
                +(st.contains("\n") ? st + "</p><p>" : st)+"</span>";
            }
            
        }
        result+= "</p>";
        return result;
    }
    
    public String getRandomColor(int maxR, int minR, int maxG, int minG, int maxB, int minB){
        int r = (int) (Math.random()*(maxR-minR)+minR);
        int g = (int) (Math.random()*(maxG-minG)+minG);
        int b = (int) (Math.random()*(maxB-minB)+minB);
        return "#" 
                + addMissingZero(Integer.toHexString(r))
                + addMissingZero(Integer.toHexString(g)) 
                + addMissingZero(Integer.toHexString(b));
    }
    
    private String addMissingZero(String hexa){
        while (hexa.length() < 2){
            hexa = "0"+hexa;
        }
        return hexa;
    }
    
    public String getRandomSize(int min, int max){
        return (int) (Math.random()*(max-min))+min+"px";
    }
    
    public String getRandomFontfamily(){
        ArrayList<String> families = new ArrayList<>();
        families.add("Comic Sans MS");
        families.add("Impact");
        families.add("Trebuchet MS");
        families.add("Arial");
        families.add("Courier New");
        
        return "\"" + families.get((int)(Math.random()*families.size())) + "\"";
    }
    
}
