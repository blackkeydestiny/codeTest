package com.xujian.demo;

public class RemoveChars {

    public static void main(String[] args) {

        String input = "aabcccbbad";
        System.out.println("input: " + input);
        if (Common.checkInput(input)) {
            System.out.println("output: ");
            Common.removeThreeOrMoreIdenticalCharacters(input);
        } else {
            System.out.println("input error!");
        }

    }

}
