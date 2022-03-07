package com.xujian.demo;

public class ReplaceChars {

    public static void main(String[] args) {

        String input = "abcccbad";
        System.out.println("input: " + input);
        if (Common.checkInput(input)) {
            System.out.println("output: ");
            Common.replaceThreeOrMoreIdenticalCharacters(input);
        } else {
            System.out.println("input error!");
        }

    }

}
