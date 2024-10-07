package com.company;

public class Solution {
    public static void main(String[] args) {
        String s = "aoaoooooo";
        System.out.println(percentageLetter(s,'o'));
    }
    public static int percentageLetter(String s, char letter) {
        int count = 0;
        double result = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==letter){
                count++;
            }
        }
        //если не принимает то надо раскомментить
        //result = count * 100;
        //result = result / s.length();
        //System.out.println(result);
        res = count * 100;
        res = res / s.length();
        //int finalres = 0;
        //if (result-res>0.5){
        //    finalres = (int) Math.ceil(result);
        //} else finalres = (int) Math.floor(result);
        return res; //и сюда поставить finalres
    }

}
