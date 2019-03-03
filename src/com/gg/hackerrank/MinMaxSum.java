package com.gg.hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by gayathrig on 01/03/2019.
 * https://www.hackerrank.com/challenges/mini-max-sum/problem
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 * <p>
 * For example, . Our minimum sum is  and our maximum sum is . We would print
 */
public class MinMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {


        ArrayList<Long> numbers = new ArrayList<>();
        for (int i : arr
                ) {
            numbers.add(new Long(String.valueOf(i)));
        }
        //max sum
        Long maxSum=numbers.stream().sorted().skip(1).collect(Collectors.summingLong(x->x));
        Long minSum=numbers.stream().sorted(Comparator.reverseOrder()).skip(1).collect(Collectors.summingLong(x->x));
        System.out.println(minSum+" "+maxSum);
    }


    private static ArrayList<Long> convertArrayType(int[] arr) {

        ArrayList<Long> numbers = new ArrayList<>();
        for (int i : arr
                ) {
            numbers.add(new Long(String.valueOf(i)));
        }

        return numbers;

    }

    private static final Scanner scanner = new Scanner(System.in);

      /*  public static void main(String[] args) {
            int[] arr = new int[5];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < 5; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            miniMaxSum(arr);

            scanner.close();
        }*/

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        miniMaxSum(arr);
    }
}

