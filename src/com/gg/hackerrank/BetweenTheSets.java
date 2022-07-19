package com.gg.hackerrank;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BetweenTheSets
{

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         *
         */
        int count=0;
        List<Integer> aBoxed=new ArrayList<Integer>();
        for (int i=0;i<a.length;i++
             ) {
            aBoxed.add(new Integer(a[i]));
        }


        List<Integer> bBoxed=new ArrayList<Integer>();
        for (int i=0;i<b.length;i++
                ) {
            bBoxed.add(new Integer(b[i]));
        }

        int maxOfA=aBoxed.stream().max(Comparator.naturalOrder()).get();
        int minOfB=bBoxed.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Values are "+maxOfA+ ","+minOfB);

        List<Integer> betweenAandB= IntStream.rangeClosed(maxOfA,minOfB).boxed().collect(Collectors.toList());

        System.out.println("betweenAandB"+betweenAandB);

        long result =betweenAandB.stream().filter(x -> isAFactorOfAll(x,bBoxed) && isAMultiplerOfAll(x,aBoxed)).count();
        System.out.println("result "+result);

        return Math.toIntExact(result);
    }




    private static Boolean isAFactorOfAll(int x,List<Integer> a){
        System.out.println("isAFactorOfAll "+x+" ="+a.stream().allMatch(n-> n%x==0));

        return  a.stream().allMatch(n-> n%x==0);

    }


    private static Boolean isAMultiplerOfAll(int x,List<Integer> a){
        System.out.println("isAMultiplerOfAll "+x+" ="+a.stream().allMatch(n-> x%n==0));
        return  a.stream().allMatch(n-> x%n==0);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }*/

        int[] a ={2,4};
        int[] b ={16,32,96};
        int total = getTotalX(a, b);

     /*   bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();*/
    }
}
