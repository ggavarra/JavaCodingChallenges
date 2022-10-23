package com.gg.gs.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Do not use any built-in classes
 */
public class MutilplyTwoNumbers {
    public static void main(String[] args) {
        String num1 = "120";
        String num2 = "012";

        //Strip the leading zeroes
        char[] num1chars = MutilplyTwoNumbers.removeLeadingZeroes(num1).toCharArray();
        char[] num2chars = MutilplyTwoNumbers.removeLeadingZeroes(num1).toCharArray();
        num2 = removeLeadingZeroes(num2);

        for (int i = num1chars.length-1; i > 0; i--) {
            System.out.println(i);

            for (int j = num2chars.length-1; j > 0; j--) {
                System.out.println("i=" + num1chars[i] + ", j=" + num2chars[j] + ", product=" + ( Character.getNumericValue(num1chars[i]) * Character.getNumericValue(num2chars[j])));
            }

        }


    }

    private static String removeLeadingZeroes(String num) {
        int count = 0;
        char[] chars = num.toCharArray();
        //System.out.println("chars[count]=" + chars[count]);
        while (chars[count] == '0') {
            count++;
            //System.out.println("count="+count);
        }
        //System.out.println("Number of leading zeros"+ count +", NonLeadingZeroString is "+num.substring(count));
        return num.substring(count);
    }
}
