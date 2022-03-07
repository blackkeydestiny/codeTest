package com.xujian.demo;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Common {

    /**
     * 在目标字符串中，删除连续的3个及以上数量的相同的字符
     *
     * @param input 输入的目标字符串
     */
    public static void removeThreeOrMoreIdenticalCharacters(String input) {

        // 递归标识，默认为不递归
        boolean recursionFlag = false;
        // 得到input中相同字符的字符串的列表
        ArrayList<String> identicalCharsList = fetchIdenticalCharsList(input);
        if (identicalCharsList.size() > 0) {
            recursionFlag = true;
        }
        // 遍历，将相同字符的字符串删除
        for (int i = 0; i < identicalCharsList.size(); i++) {
            input = input.replace(identicalCharsList.get(i), "");
        }

        // 递归
        if (recursionFlag) {
            System.out.println("-> " + input);
            removeThreeOrMoreIdenticalCharacters(input);
        }
    }

    /**
     * 在目标字符串中，替换连续的3个及以上数量的相同的字符
     * 替换规则：
     *      按字典顺序，替换成该字母的前一个字母
     *      如果该字母是"a",则替换成空串
     *
     * @param input 输入的目标字符串
     */
    public static void replaceThreeOrMoreIdenticalCharacters(String input) {

        // 递归标识，默认为不递归
        boolean recursionFlag = false;
        // 得到input中相同字符的字符串的列表
        ArrayList<String> identicalCharsList = fetchIdenticalCharsList(input);
        if (identicalCharsList.size() > 0) {
            recursionFlag = true;
        }
        // 遍历，将相同字符的字符串替换，替换成该字母的前一个字母，如果该字母是"a",则替换成空串
        for (int i = 0; i < identicalCharsList.size(); i++) {
            String identicalChars = identicalCharsList.get(i);
            char oldChar = identicalChars.charAt(0);
            char newChar = (char) (oldChar - 1);
            String replaceStr = "";
            String resultStr = "empty string";
            if (oldChar != 'a') {
                replaceStr = String.valueOf(newChar);
                resultStr = replaceStr;
            }
            input = input.replace(identicalChars, replaceStr);
            System.out.println("-> " + input + ", " + identicalChars + " is replaced by " + resultStr);
        }

        // 递归
        if (recursionFlag) {
            replaceThreeOrMoreIdenticalCharacters(input);
        }
    }

    /**
     * 获取相同字符组成的字符串的列表
     *
     * @param input 输入的字符串
     * @return 字符串列表
     */
    public static ArrayList<String> fetchIdenticalCharsList(String input) {

        // 与当前字符 相同的字符的 个数
        int deinticalNum = 1;
        // 相同的字符的总个数，大于等于3个时，会被放入队列
        int limitNum = 3;
        // 存放相同的字符的列表
        ArrayList<String> identicalCharsList = new ArrayList();

        // 遍历，对字符串中的串两两比较
        for (int i = 0; i < input.length() - 1; i++) {
            char currentChar = input.charAt(i);
            char nextChar = input.charAt(i + 1);
            if (currentChar == nextChar) {
                // 当前字符与下一个字符相同，相同的字符个数加1
                deinticalNum++;
                // 如果下一个字符是字符串中最后一个字符，并且相同的字符大于3时，将相同的字符放入列表
                if ((i + 1) == (input.length() - 1) && deinticalNum >= limitNum) {
                    StringBuffer identicalChars = new StringBuffer();
                    for (int j = 0; j < deinticalNum; j++) {
                        identicalChars.append(currentChar);
                    }
                    identicalCharsList.add(identicalChars.toString());
                }
            } else {
                // 两两比较，当两个字母不同时，比较相同的字符是否大等于3，是的话，将相同的字符放入列表
                if (deinticalNum >= limitNum) {
                    StringBuffer identicalChars = new StringBuffer();
                    for (int j = 0; j < deinticalNum; j++) {
                        identicalChars.append(currentChar);
                    }
                    identicalCharsList.add(identicalChars.toString());
                }
                // 将相同的字符的个数重置为1
                deinticalNum = 1;
            }
        }

        return identicalCharsList;
    }

    /**
     * 校验输入
     * @param input 输入的字符串
     * @return true|false
     */
    public static boolean checkInput(String input) {
        boolean checkflag = false;
        String pattern = "([a-z]){0,}";
        if (input != null && input.length() > 0 && Pattern.matches(pattern, input)) {
            checkflag = true;
        }
        return checkflag;
    }

}
