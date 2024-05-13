package com.gpnu.cn.utils;
import java.util.HashSet;
import java.util.Set;
public class StrJaccard {
    public static void main(String[] args) {
    }
    public double jaccard(String str1,String str2) {
        Set<Character> s1 = new HashSet<>();
        Set<Character> s2 = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            s1.add(str1.charAt(i));//将string里面的元素一个一个按索引放进set集合
        }
        for (int j = 0; j < str2.length(); j++) {
            s2.add(str2.charAt(j));
        }
        float mergeNum = 0;//并集元素个数
        float commonNum = 0;//相同元素个数（交集）
        for(Character ch1:s1) {
            for(Character ch2:s2) {
                if(ch1.equals(ch2)) {
                    commonNum++;
                }
            }
        }
        mergeNum = s1.size()+s2.size()-commonNum;
        double jaccard = commonNum/mergeNum;
        return jaccard;
    }
}