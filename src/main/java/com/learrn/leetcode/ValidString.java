package com.learrn.leetcode;

/*
1003. 检查替换后的词是否有效
给你一个字符串 s ，请你判断它是否 有效 。
字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ：

将字符串 "abc" 插入到 t 中的任意位置。形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + tright 。注意，tleft 和 tright 可能为 空 。
如果字符串 s 有效，则返回 true；否则，返回 false。
 */
public class ValidString {
    public static void main(String[] args) {
        String s = "aababccbc";
        boolean result = new ValidString().isValid(s);
        System.out.println(result);
    }

    public boolean isValid(String s) {
        String abc = "abc";
        while (s.contains(abc)){
            s = s.replace(abc, "");
        }
        return s.isEmpty();
    }
}
