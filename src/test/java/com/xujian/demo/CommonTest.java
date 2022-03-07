package com.xujian.demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommonTest {

    @Test
    public void removeThreeOrMoreIdenticalCharacters() {
        String input = "aabcccbbad";
        System.out.println("input: " + input);
        if (Common.checkInput(input)) {
            System.out.println("output: ");
            Common.removeThreeOrMoreIdenticalCharacters(input);
        } else {
            System.out.println("input error!");
        }
    }

    @Test
    public void replaceThreeOrMoreIdenticalCharacters() {
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